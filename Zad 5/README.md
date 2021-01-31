# ARTOS (Art of System Testing)

![ARTOS](IMAGES/Artos.png)

## Wprowadzenie
************

Artos jest zaprojektowany przez grupę doświadczonych testerów jako **darmowy** oraz **open-source** projekt do pomocy społęczności testerów na całym świecie.
Jego celem jest dostarczenie frameworków do tesotowania, które są proste w obsłudze. Artos jest napisny w Javie co czyni go użytecznym na każdym systemie operacyjnym, które obsługują język Java. Może być używany dla funkcjonalnych, systemowych, end to end lub nawet junit testów. Dodatkowo zawiera proste lecz skuteczne definicje jak wiele wbudowanych i dobrze przetestowanych udogodnień. Dzięki temu można skupić się na pisaniu orpogramowania nie martwiąc się o skomplikowaną formę pisania testów.

## Słownik Frameworka
************

|**Keyword** | **Description**|
| ------------- | ------------- |
|Test suite | A collection of test cases that are designed specifically to test the system under test|
|Test runner | A class which is the entry point to a test application. It is responsible for running and tracking test cases from the start to end|
|Test case | A class which contains set of instructions that will be performed on the system under test|
|Test unit | A method within a test case that represents the smallest and independent executable unit|
|Test context | A container object that stores and tracks test suite, test case and test unit related information|
|Test script | A set of instructions to guide the test runner on how to execute test cases. The test script is represented by xml script|
|Scan scope | A section of the Java project which will be scanned during the search of test cases|
|Test status | The state of a test case at the time of execution (namely: PASS, FAIL, SKIP or KTF)|
|Unit outcome | The outcome of the test unit (namely: PASS, FAIL, SKIP or KTF)|
|Test outcome | The outcome of the test case (namely: PASS, FAIL, SKIP or KTF)|
|Fail stamp | The text stamp added to a log stream at the line of failure|
|GUI test selector | Prompt that displays scoped test cases and allow the user to run selective test cases|
|Failure highlight | Textually representation of failed test cases and its unit for user|


## Skróty
************
   
      KTF , "Known To Fail"
      GUI , "Graphic user interface"


## Komentarze
************

ARTOS używa skrótów Javy dla większości funkcji. Lista wpsieranych skrótów wylistowana poniżej.


|Annotation | Applies To | Usage|
| ------------- | ------------- | ------------- |
|@TestCase | Class | Denotes that class is a test case
|@TestPlan | Class | Declares information required for test plan
|@Unit | Method | Denotes that method is a test unit
|@BeforeTestSuite | Method | Denotes that the annotated method should be executed once before test suite execution|
|@AfterTestSuite | Method | Denotes that the annotated method should be executed once after test suite execution|
|@BeforeTest | Method | Denotes that the annotated method should be executed before each test case execution|
|@AfterTest | Method | Denotes that the annotated method should be executed after each test case execution|
|@BeforeTestUnit | Method | Denotes that the annotated method should be executed before each test unit execution|
|@AfterTestUnit | Method | Denotes that the annotated method should be executed after each test unit execution|
|@AfterFailedUnit | Method | Denotes that the annotated method should be executed after each failed test unit execution|
|@DataProvider | Method | Denotes that the annotated method is the supplier of a test data and declares a unique name for the method|
|@ExpectedException | Method | Declares rules of managing exception of the annotated method|
|@Group | Class/Method | Declares group name(s) that the annotated test case/unit belongs to|
|@KnownToFail | Method | Declares that the annotated test unit is known to fail|
|@TestImportance | Class/method | Declares importance of the annotated test case/unit|
|@TestDependency | Class | Declares test case dependency on other test case(s)|
|@UnitDependency | Method | Declares unit dependency on other unit(s) implemented within single test case|
|@StepDefinition | Method | Declares step definition that binds test unit to feature file|


## Przykłady użycia
************


      import com.artos.annotation.*;
      import com.artos.framework.Enums.Importance;
      import com.artos.framework.Enums.TestStatus;
      import com.artos.framework.infra.TestContext;
      import com.artos.interfaces.TestExecutable;

      @TestImportance(Importance.CRITICAL)
      @Group(group = "Regression")
      @TestPlan(preparedBy = "ArtosTeam", bdd = "GIVEN..WHEN..AND..THEN..")
      @TestCase(sequence = 1)
      public class Sample_1 implements TestExecutable {

         @Group(group = "BADPATH")
         @TestImportance(Importance.LOW)
         @Unit(sequence = 1)
         public void testUnit_1(TestContext context) {
            // --------------------------------------------------
            context.setTestStatus(TestStatus.FAIL, "Bad path");
            // --------------------------------------------------
         }
      
         @Group(group = "GOODPATH")
         @TestImportance(Importance.HIGH)
         @Unit(sequence = 2)
         public void testUnit_2(TestContext context) {
            // ---------------------------------------------------
            context.setTestStatus(TestStatus.PASS, "Good path");
            // ---------------------------------------------------
         }

      }

