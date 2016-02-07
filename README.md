# PersianDT [![](https://jitpack.io/v/abbashosseini/PersianDT.svg)](https://jitpack.io/#abbashosseini/PersianDT)
>Android PesianDt library its for conversion EnglishDate to Persian (Jalali/Shamsi). the reason to create **PersianDT** because i'm not finding any on the net maybe was but so far in my research not found any  /
>این کتابخانه برای تبدیل تاریخ میلادی به  شمسی  است . این رو نوشتم چون من نیاز داشتم ولی پیدا نکردم حداقل تا انجای که جستجو کردم .

#### About :

in this small library you can easily work with EnglishDate and Display for **users** more _Readable_ dates  .

You can Done This Follow Option With PerisanDT :

* you can get Time in **Ago** format like this **a year ago** / می توان تاریخ را به صورت **۱ سال پیش** نشان داد
* You Can Get Name of day of the week form **any** Date like SunDay / می توان نام روز هر تاریخ را نشان داد مانند : یکشنبه
* You can get Date With _MonthName_ Like This **2016 Jun 1** / می توان ناریخ را همراه با نام ماه نشان داد مانند : **۱۳۹۴ بهمن ۱**
* Yout can get dates compelete in _digit_ format like this **2016/01/01** / می9توان کامل عددی نشان داد مانند **۱۳۹۴/۱۱/۰۱**

#### ScreenShot :

![Image of PerisanDT](https://github.com/abbashosseini/PersianDT/blob/master/ScreenShots/2016-02-07-013831.png)


![Image of PerisanDT](https://github.com/abbashosseini/PersianDT/blob/master/ScreenShots/2016-02-07-014243.png)

#### use it :

- [x] get _day_ of week **name** / گرفتن نام روز هفته از تاریخ مورد نظر شما

```java
  CurrentDate.getDay(dateString)
````

- [x] get date _compelete_ in **digit** format  / گرفتن تاریخ شمسی و عددی از تاریخ مورد نظر شما

```java
  GenerateDates.getyourDate(dateString)
````

- [x] get Month With Letters and digit format With **Example** / گرفتن تاریخ شمسی همراه با نام ماه  از تاریخ مورد نظر شما
```java
  CurrentDate currentDate = new CurrentDate();
        TextElemet.setText(
                currentDate.getdateWithMonthLetters(
                        GenerateDates.getyourDate(dateString)
                )
        );
````

- [x] get current Date  / گرقتن تاریخ فعلی از سیستم عامل

```java

  CurrentDate currentDate = new CurrentDate();
        TextElemet.setText(
                currentDate.getdateWithMonthLetters(
                        GenerateDates.getCurrentDate()
                )
        );
````
#### Gradle - installing / نصب :

* Add it in your root build.gradle :

```gradle

	allprojects {
		repositories {
			maven { url "https://jitpack.io" }
		}
	}

```
* . Add the dependency


```gradle

dependencies {
	        compile 'com.github.abbashosseini:PersianDT:-SNAPSHOT'
	}

```

####Maven :

```xml

<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```
```xml

<dependency>
    <groupId>com.github.abbashosseini</groupId>
    <artifactId>PersianDT</artifactId>
    <version>-SNAPSHOT</version>
</dependency>

```


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

