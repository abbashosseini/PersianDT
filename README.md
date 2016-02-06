# PersianDT
Android PesianDt library its for conversion EnglishDate to Persian (Jalali/Shamsi).

#### About :

in this small library you can easily work with EnglishDate and Display for **users** more _Readable_ dates .

You can Done This Follow Option With PerisanDT :

* you can get Time in **Ago** format like this **a year ago**
* You Can You Get name Day of week **any** Date .
* You can get Date With _MonthName_ Like This **1394 bahman 1**.
* Yout can get dates compelete in _digit_ format like this **1394/11/1**.

#### ScreenShot :

![Image of PerisanDT](https://github.com/abbashosseini/PersianDT/blob/master/ScreenShots/2016-02-07-013831.png)


![Image of PerisanDT](https://github.com/abbashosseini/PersianDT/blob/master/ScreenShots/2016-02-07-014243.png)

#### use it :

- [x] get _day_ of week **name**

```java
  CurrentDate.getDay(date)
````

- [x] get date _compelete_ in **digit** format 

```java
  GenerateDates.getyourDate(date)
````

- [x] get Month With Letters and digit format Woth **Example**. :
```java
  CurrentDate currentDate = new CurrentDate();
        TextElemet.setText(
                currentDate.getdateWithMonthLetters(
                        GenerateDates.getyourDate(date)
                )
        );
````

- [x] get current Date :

```java

  CurrentDate currentDate = new CurrentDate();
        TextElemet.setText(
                currentDate.getdateWithMonthLetters(
                        GenerateDates.getCurrentDate()
                )
        );
````

###License

	Copyright (C) 2016 AbbasHosseini
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	    http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

