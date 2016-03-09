# PersianDT [![](https://jitpack.io/v/abbashosseini/PersianDT.svg)](https://jitpack.io/#abbashosseini/PersianDT)
> PesianDt library its for conversion English date to Persian date (Jalali/Shamsi). 
the reason to create **PersianDT** because i'm not finding any on the net maybe was but so far in my research not found any. .

#### About 

in this library you can easily work with English date and Display more _Readable_ dates for  **users** .

You can Done This Follow Option With PerisanDT :

* you can get Time in **Ago** format like this **a year ago** .
* You Can Get Name of day of the week form **any** Date like SunDay .
* You can get Date generated for you like  `WithLetter` or `withDigit` : **2016 Jun 1** or **3016/01/01** .
* Yout can now pass your dates `new Date` for example and gets Days name.
* You Can with this `{DATE}` _markdown_ mark a `date` how you like to set place for dates in sentence.

#### trick 

if you dont care about `date` Object whee gonna be shows  or you dont have sentence you can choose :

* "" 
* PersianDT.Location.OFF `just for aspect of code !`

instead or any object you like (any object is not extends String its `harmless` dont worry )


#### importand

if you have sentence you **have** too use `{DATE}` markdown.



#### ScreenShot 

![Image of PerisanDT](https://github.com/abbashosseini/PersianDT/blob/master/ScreenShots/2016-02-07-013831.png)


![Image of PerisanDT](https://github.com/abbashosseini/PersianDT/blob/master/ScreenShots/2016-02-07-014243.png)

#### use it 

- [x] get _day_ of week **name** 

```java
  	
  	PersianDT
                .Instance()
                .generate(date, " {DATE}")
                .into(textView, Generate.Task.DAY);
  
  
````

- [x] get date _compelete_ in **digit** format 

```java
  
  	PersianDT
                .Instance()
                .generate(date, " {DATE}")
                .into(textView, Generate.Task.DATE); //just change Enum `DAY` to `DATE`
````

- [x] get current dates `withletters`

```java

  	
        PersianDT
                .Instance()
                .Current(" {DATE}") 
                .into(textView, Current.Job.WithLetter);
        
        
````

- [x] get current Date `withDigit`  

```java

        PersianDT
                .Instance()
                .Current(" {DATE}")
                .into(Textview, Current.Job.WithDigit);

````

## if you are need `result` follow this steps

#### get Day from dates


```java
  	
  	PersianDT
                .Instance()
                .generate(date, " {DATE}")
                .getDay(); // Day
  
  
````


#### get persian date result and what ever


```java
	
	PersianDT
                .Instance()
                .generate(date, " {DATE}")
                .getCalendar(); // PersianDate
  
  
````


### get current dates compelete `digit` result


```java
  	
  	
        PersianDT
                .Instance()
                .Current(" {DATE}")
                .withDigit(); //just Digit
  
  
````


### get current date mix it with `Letters`


```java
  	

        PersianDT
                .Instance()
                .Current(" {DATE}")
                .withLetter(); // MonthName
  
  
````

#### Gradle - installing 

* Add it in your root build.gradle :

```gradle

	repositories {
			maven { url "https://jitpack.io" }
		}
	}
	

```
* . Add the dependency


```gradle

	dependencies {
	        compile 'com.github.abbashosseini:PersianDT:v1.0.0'
	}
```

#OR

######i can't put it in JCenter / Bintary Right now ! so

Add aar file locally :

1. [Download](https://github.com/abbashosseini/PersianDT/blob/master/persian-time-release.aar?raw=true) AAR File .
2. go to file > New Module > Import .JAR or .AAR Package
3. Imported and in dependencies add :

```gradle 

dependencies {
    compile project(':persian-time-release')
}

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

