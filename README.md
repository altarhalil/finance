### Problem definition 

Create a tiny RESTful web service with the following business requirements: 

- Application must expose REST API endpoints for the following functionality: 

         - apply for loan (`idNumber`,  `name`, `surname` ,`msisdn` and `monthlyIncome` must be provided) 

- Service must perform loan application validation according to the following rules and reject application if: 

         - .... 

### Compiling 

Compile with maven: mvn clean install 

  
### Running 

Run as a simple jar: java -jar loanservice-0.0.1-SNAPSHOT.jar 

  
### Configuration 

Config file is application.yml in src/main/resources 

Defaults are:  

app: 
    creditMultiplier: 4 
    defaultMediumSegmentLimit: 10000 
    description: ${app.name} is a spring boot app that demonstrates how to use external configuration properties 
    highestCreditScore: 1000 
    lowestCreditScore: 500 
    montlyIncomeLimit: 5000 
    name: ConfigurationPropertiesLoanService 
    smsDescription: '"Sayin {}  kredi basvurunuz onaylanmistir, Kredi limitiniz : {}"' 

spring: 
    data: 
        mongodb: 
            database: test 
            port: 27017 

### REST endpoints 

 Apply for a loan: 

POST /loans/apply 

Example JSON object for loan 

{       "idNumber": 12345678912, 
        "name":"Halil", 
        "surName": "Altar", 
        "msisdn": "54256149**", 
        "monthlyIncome": 4000 
} 

  

**Good luck and have fun!** 

 
