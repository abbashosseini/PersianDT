# PersianDT
>PesianDate for JAVA :date:

<p align="center">
  <img src="https://github.com/abbashosseini/PersianDT/raw/master/logo.png"/>
</p>


####About
persianDT its for persian guys WANT date in PERSIN LANGUAGE more readable and freindly and most important easy use 
generate and create such dates for them.
you can access date in two ways :

* Asynchorouns
* synchronous

and PersianDT is **ThreadSafe** and its build on top of 3 design pattern 

* CallBack Pattern
* Builder Pattern
* Singleton Pattern

###What can i do :

* can create dates direclty from System 
* can Create dates from Given date
* You can put anywhere in the string you want
  * Paragrph
  * Sentence
  * WebPage
  * WhatEver
* Can Custom your date if you want
* Can you use MarkDown `{DATE}`to Specified where you want date to be displayed - Text/String
* can you create date in Ago Format like `2016 Apr 1` become `1 day ago`


##Asynchronous Response :

so if you wanna get reponse Asynchronous You have to use `CallBack Interface` and for using it you have to know how 
in PersianDt you can fill and get response in couple of ways like :

 1. implement CallBack
 2. Lambda/Method Refernce (JAVA8)
 3. Anonymous implement
 

### if you have any trouble Read [JavaDoc!](http://abbashosseini.github.io/PersianDT/)
[Current](https://github.com/abbashosseini/PersianDT/blob/master/src/main/java/com/hosseini/persian/dt/PersianDate/Current.java#L44-L45) Class **Deprecated**

```java

//implement CallBack
 public class useItEasyWayLikeBuilderpattern implements CallBack {
        public static void main(String[] strings) {
              new useItEasyWayLikeBuilderpattern().date();
        }
        
 public void date() {
     
     
  PersianDT
          .Instance()
          .generate(new Date(),"Current persian date in your device is {DATE} witout year.")
          .CallBack(this)
          .generateWithoutYear();
     
 }

 @Override
 public void onReceive(String date) {
       System.out.println(date);
 }

```


```java

        // in java 8
        int random = new Random().nextInt(12);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, random);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());

        //Lambda
        PersianDT
                .Instance()
                .generate(format, "{DATE}")
                .CallBack(date -> System.out.println(date))
                .Separator("_")
                .generateFullDate();



        //method reference
        PersianD
                .Instance()
                .generate(format, "{DATE}")
                .CallBack(System.out::println)
                .Separator("--")
                .generateWithMonthName();

```

```java

    //Anonymous implement
    PersianDT
            .Instance()
            .generate(format, "{DATE}")
            .CallBack(new CallBack() {
                @Override
                public void onReceive(String date) {
                    System.out.println(date);
                }
            })
            .Separator(" | ")
            .generateWithMonthName();

```

#### Initializing :

##### you can use Builder Pattern Style :

```Java
  PersianDT
     .Instance()
     .generate(format, "{DATE}")
     .CallBack(System.out::println)
     .Separator("--")
     .generateWithMonthName();
```
you can see (BuilderPattern) Example in [here](https://github.com/abbashosseini/PersianDT/blob/master/src/main/java/com/hosseini/persian/dt/Example/generate/useitLikeBuilderpattern.java) 

#### what if i need day, month, year and more in _separate_ :

you can create instance of `Generate` class and keep the instance and get any part you want separately 
please check this [Example](https://github.com/abbashosseini/PersianDT/blob/master/src/main/java/com/hosseini/persian/dt/Example/generate/CustomDate.java)
  
#####you can use it to create appropriate instance :  

   [Example 1- Customize your date](https://github.com/abbashosseini/PersianDT/blob/master/src/main/java/com/hosseini/persian/dt/Example/generate/CustomDate.java)
   
   [Example 2- Customize your date](https://github.com/abbashosseini/PersianDT/blob/master/src/main/java/com/hosseini/persian/dt/Example/current/CustomYourdate.java)
   
#####Create date in Ago Format :

[Example 1- Ago Format](https://github.com/abbashosseini/PersianDT/blob/master/src/main/java/com/hosseini/persian/dt/Example/ago/useitLLikeBuilderPattern.java)

## installing :

download the jar file from [HERE](https://github.com/abbashosseini/PersianDT/releases/download/0.1/PersianDT.jar)

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
