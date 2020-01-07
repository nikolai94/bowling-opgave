# Bowling opgave
Hejsa.
Selve algoritmen til at beregne bowling score'n er i class'en [Calculate](https://github.com/nikolai94/bowling-opgave/blob/master/src/main/java/Calculate.java).

## How to run this project
For at køre programmet gå til class'en [Main](https://github.com/nikolai94/bowling-opgave/blob/master/src/main/java/Main.java), og køre Java filen. Programmet vil derefter gøre følgende:  
1. Kalde GET endpointet
2. Beregne summen
3. Kalde POST endpointet og tjekke at summen er rigtig

Alt dette bliver udskrevet i console'n, men kan også findes i en log fil som vil lægge i root mappen. Filen bliver oprettet første gang programmet køre. Filen hedder 'logfile.log'.
Man kan også se nogle af de kald jeg selv har lavet til API'et i log filen her på github. [LogFile](https://github.com/nikolai94/bowling-opgave/blob/master/src/main/java/logs/logfile.log). 

## Test
Filen [Calculate](https://github.com/nikolai94/bowling-opgave/blob/master/src/main/java/Calculate.java) er blevet unit testet i filen [CalculateTest](https://github.com/nikolai94/bowling-opgave/blob/master/src/test/java/CalculateTest.java). Jeg har lavet en 'Parameterized' test med nogle forskellige test cases.

## Install this project
Alle java libraries kan hentes via Maven.
