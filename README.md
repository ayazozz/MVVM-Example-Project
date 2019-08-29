# MVVM-Example-Project
Currency App

This mobile application views currencies list of 33 countries. Furthermore, the user can list the details of each currency to display the relative values of the currency.

###  The flow Schema Of Recipes Application

![screenshoot](https://user-images.githubusercontent.com/38051809/63983927-381a5d80-cac9-11e9-8dda-e3196b98b6cd.jpg)

###  REST Api and Data Model

The „ApiService“ class is created to do api request. This class includes one companion object to create retrofit object and two api request (to get currency list and currency rates list) interfaces. These api requests return Json value. Incuding rates value that json generates data model classes.There are 2 data classes in the project.

1 CurrencyData
2 Rates

** Note 1 : Get all currency list api doesn’t include „EUR“ currency rate value. That’s
why, after request, this value should add to response list

