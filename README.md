### InnosabiCode
It is a gradle project with Selenium and TestNG framework. The programming language used is Java.

The test environment it was developed in is
- OS: Windows
- Browser: Chrome

Test case **Create an idea and comment** can be run from **build.gradle** file.

**Test Steps:** \
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Go to https://e2e.innosabi.com.\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Enter email and click on Next button.\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. Enter password and click on Login button.\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. Click on Innovation challenge card.\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. Click on Submit Idea button.\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6. Enter idea and description fields.Click Submit button.\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7. Enter a comment for another idea and click Send button.\

The locators for Web elements are stored in the corresponding classes in ```pages``` package.\
Random test data is created and can be obtained from the following class ```Utils```.\
The class ```src/test/java/innosabi/qa/automat/UI/CreateAnIdeaAndComment.java``` contains the implementation of test case.
