Todo
---
* Add test cases for customer controller, service, and dao. Start with dao since that might be easiest.
* Add initial UI.
* Switch to JPA instead of JDBC. This involves switching to MySQL. For which we should make
another spring profile instead of removing the h2 profile because we might still
want to maintain the h2 profile for dev/testing purposes.
* How do we bootstrap the db as opposed to raw sql file as with h2?


Questions
---
* Should methods like delete and insert etc, when invoked via the controller's endpoints return certain http codes
as well as textual responses to indicate success or failure of the requested operations? For example should the delete
method in the customer dao return a boolean to indicate successful deletion of the requested record? And if so, should
this be propagated towards the presentation layer via the service and the controller's calling methods and hence
be seen as a response in something like Postman while testing?
* For updating an existing customer via Postman, is it better practice to provide the target customer's id as a url
parameter, or as part of the posted JSON body?

Fun stuff
---
* See what app looks like in jvisualvm.
* How do we get our objects to show up in jconsole, as they currently don't.
