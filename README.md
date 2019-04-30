# ReportsCollector
What we can do here
					
1.You can create user using adrress https://reportscollector.herokuapp.com/createUser method post
your body {"email":"test@com.com", "password":"123456"} header (Content-Type : "application/json") 

2.You can login here using adrress https://reportscollector.herokuapp.com/login method post
your body {"email":"test@com.com", "password":"123456"} header (Content-Type : "application/json") 

3. You can get user from db  https://reportscollector.herokuapp.com/email/getUserByEmail method get
You need to put email variable to path .Type of variable "email" String.

4. You can get user from db  https://reportscollector.herokuapp.com/id/getUserById method get
You need to put id variable to path . Type of variable "id" String.

5. You can send a report to dabase https://reportscollector.herokuapp.com/userId/collector/report method post
your body {"media_name": "test.png" ,"duration":"4.492","displayed_at": 123123 } header (Content-Type : "application/json")
Type of variable "userId" String.

6. You can get all reports from a db  https://reportscollector.herokuapp.com/getAllReports method get

7. You can all special user reports from a db  https://reportscollector.herokuapp.com/userKey/getAllReports method get
Type of variable "userId" String.

8. You can get all reports from db by time https://reportscollector.herokuapp.com/fromTime/toTime/getAllReportsByTime method get
If you want to see all reports fromDate to Date.
Type of variable "fromTime" ,toTime Long.


