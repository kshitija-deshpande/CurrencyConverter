# Currency Converter

This Android app is use to convert currenencies of more than hundred countries. This project is written in Kotlin

# Build

1. Open the project 'Currency Converter' in Android Studio
2. Wait for couple of mins for gradle sync
3. Make sure you selected 'app' in Edit/Run debug config
4. After gradle sync, click on Play button to run it on Emulator or device.
5. This app only uses Retrofit as external library, no other external library is used in this project

# APIs

1. App uses /live api to fetch latest currencies. More documentation https://currencylayer.com/documentation
2. CurrencyLayer.com provides free account which provide 250 APIs per month
3. Total currency conversions using /live API are for 160 countries
4. Used Retrofit library to get all the currencies in POJO.
5. Used http://www.jsonschema2pojo.org/ for converting big response from /live API to convert into POJO

# Classes

Some important classes discussed here.

## MainActivity.kt

This file contains the UI logic and activity lifecycle methods to show the screen to user to convert currencies. It is divided into 3 parts

1. Currency Layout - showing currencies, on clicking them, a dailog with all the currencies is shown and user can change the FROM or TO currency
2. Input Layout - to get the input from user, it only supports getting input in SOURCE/FROM edit text
3. Live/Chart Layout - This layout/view shows the live currencies with respect to USD as source and chart view to show chart for last 1 month, not done till now.

## CurrencyConverterController.kt

This file contains a map which holds all the currency data with KEY as code name and VALUE as the exact value got from network call. It also stored default values, in case there is no network, app can use that default value.

## ExtendedCurrency.kt

This file contains all the currency information, got this information from another library. It contains list of objects of currency information, like CODE, NAME, SYMBOL, FLAG. It is used to show the currency live list and dialog for currency selection

## CurrencyOptionAdapter.kt & LiveCurrenciesAdapter.kt

Used this adapter for showing a list view and recycler view to show list of currency options and live currencies WRT USD.

## ConvertApi.kt

CurrencyLayer API for getting live currencies. When user click on Update button (below the app) then only this network call is made as there are only 250 free calls available.

# Unit Test Cases

Unit test cases are written for core modules like CurrencyConverterController.kt and ExtendedCurrency.kt. We can write UI unit test.

## CurrencyConverterControllerUnitTest.kt unit test cases

1. Check if currency map contains USD
2. Check if some invalid currency is not there
3. Check if USD to INR is valid
4. Check if list contains 168 elements and we are not missing anything
5. (IMP) Check if convert method is working fine for currencies

## ExtendedCurrencyUnitTest.kt

1. Check if first value in currency metadata list is USD
2. Check for some intermediate data is there or not
3. Check if last entry is ZAR currency
4. Check if flag is there for some random entry or not

# Screenshots

![Alt text](/Screenshots/Img6.jpeg?raw=true "App Image 1")

![Alt text](/Screenshots/Img9.jpeg?raw=true "App Image 1")

![Alt text](/Screenshots/Img5.jpeg?raw=true "App Image 1")

![Alt text](/Screenshots/Img7.jpeg?raw=true "App Image 1")

