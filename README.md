# graphql-spring-boot-app
Spring boot application using GraphQL concept. GraphQL is a query language for API and a runtime for fulfiling those queries with our existing data.
GraphQL lets ask for what you want in a single end point

In Rest we need to create multiple end point but in graphql we need single end point.

#The main term used most commonly in GraphQL are.

1)Schema :Just like @RestController Contract between the GraphQL Client & GraphQL Server.

2)Query :Just Like GET Call in REST its used for featch data.

3)Mutation :It is similar to POST/PUT call in Rest -Used by the client for any insert /update operation.

# We need below POM dependancy

1.graphql-java-tools
2.graphql-spring-boot-starter
3.graphiql-spring-tool-starter =>For GraphQL UI

# employee.graphqls (GraphQL File)

type Employee{

   id:ID!
   name:String
   gender:String
   emailID:String
   mobileNo:String
   dob:String
   role:String
   bloodGroup:String
   salary:Int

}


type Query{

 getEmployees:[Employee]
 getEmployee(id:Int):Employee
 countEmployee: Long!
 getEmployeesByRole(role:String):[Employee]
 getEmployeesByName( name:String):[Employee]
 getEmployeesByBloodGroup(bloodGroup:String) :[Employee]
 getEmployeesBySalary(salary:Int):[Employee]
 getEmployeesBySalaryLessThan(salary:Int):[Employee]
 getEmployeesBySalaryLessThanEqual(salary:Int):[Employee]
 getEmployeesBySalaryGreaterThan(salary:Int):[Employee]


}

type Mutation{

createEmployee(name: String!,gender:String, emailID:String,   mobileNo:String,   dob:String,   role:String, bloodGroup:String,salary:Int): Employee
updateEmployee(id:Int!,name: String!,gender:String, emailID:String,   mobileNo:String,   dob:String,   role:String, bloodGroup:String,salary:Int): Employee
deleteEmployee(id:Int!):Boolean


}

schema {

query:Query

}

# Use below query API for perform GraphQL operation

1.Insert Employee Details

mutation { createEmployee( name: "Anjali", gender:"Female",emailID:"anjali@gmail.com",
 mobileNo: "9011118501", dob:"15/12/1994", role:"Developer",bloodGroup:"O+", salary:50000) { id,name,emailID } }
------------------------------------------------------
2.Update Employee Details

mutation { updateEmployee(id:14 name: "Anjali Kale", gender:"Female",emailID:"anjali@gmail.com", mobileNo: "9011118501", dob:"15/12/1994", role:"Developer",bloodGroup:"O+",salary:50000) { id,name,emailID } }
------------------------------------------------------
3.Get All Employee List

query { getEmployees{ id,name,emailID } }
--------------------------------------------------

4.Get All Employee By Blood Group

query { getEmployeesByBloodGroup(bloodGroup:"O+"){ id,name,emailID } }
-----------------------------------------------

