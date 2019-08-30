# MVVM-Example-Project
## Currency App

This mobile application views currencies list of 33 countries. Furthermore, the user can list the details of each currency to display the relative values of the currency.

- MVVM
- Livedata
- Databinding
- Navigation
- ViewPager
- Tablayout

###  The flow Schema Of Recipes Application

![screenshoot](https://user-images.githubusercontent.com/38051809/63983927-381a5d80-cac9-11e9-8dda-e3196b98b6cd.jpg)

###  REST Api and Data Model

The „ApiService“ class is created to do api request. This class includes one companion object to create retrofit object and two api request (to get currency list and currency rates list) interfaces. These api requests return Json value. Incuding rates value that json generates data model classes.There are 2 data classes in the project.

- CurrencyData
- Rates

## Activities - Fragment- Classes

When the project create, MVVM design pattern is usedBecause, we care about that when the screen rotates, it maintains the latest status and keeps information on the screen. Viewmodel layer and observable data that live data provides to do that because, they are
lifecycle awareness structures.

### 1- FirstLaunchActivity

Its for launcher screen. At the same time, it’s a starter fargment of app. It contains logo and „next“button to go to „CurrencyListFragment“.

### 2- currencyList Package
##### 2.a- CurrencyListFragment

This fragment lists currency list. There is a binding object to provide connection ui by using databinding. CurrencyListViewModel object is created by factory. It provides to us singleten feature. This fragment observes the changing and livedata values such as search value, send „getList“ request.Visibility of search text has animation. If the user scroll screen up, search text is visible, if
the user scroll screen down, it will be unvisible.

#### ** NOT 1 

Fragement does all of stuff in the „onCreateView“ function. That’s why, getList function hast to invoke from „onResume“ function to view whole list when user come back to this fragment screen after doing search.

 ##### 2.b- CurrencyListViewModel
 
This viewmodel invokes getList request function. When the fragment is created, it list first list from init. It has live data for request that observer from fargment. Also, it connected with xml file of fragment to handle search values, onclick event and send text
value to adapter.

 ##### 2.c- Adapter -ViewHolder
 
 Adapter is defined in fragment to attach values to recyclerview. Also, it handles onclick list item event. Viewmodel describes components (textview, imagevuew, etc.) of recyclerview item layout.
 
### 3- currencyDetails Package
##### 3.a- CurrencyDetailsFragment

This fragment views details of currency rates of each currencies by used viewpager and tablayout. It takes 2 params. First one is currency name of clicked by user on previous screen, second one is currencyList for tabs text of tablayout. In the same way, it includes
binding and viewmodel objects.

#### **NOT 2 

The value that requets parameter is set from livedata or fragment args to save state in rotation case. If the livedata is null, it means the fragment is creating first time, if not, the fragment is already exist, so, request param is should be live data calue.

##### 3.b- CurrencyDetailsViewModel
 
 This viewmdoel send request to api and return livedata as a result. Also, it apdates livedatas.
 
#####  3.c-CurrencyDetailsAdapter

This adapter attached thevalues for viewpager screens. And, send data to recyclerview adapter for currency rates list.

##### 3.d-CurrencyDetailsListAdapter

 This adapter attached the recyclerview datas to currency rate recyclerview.

