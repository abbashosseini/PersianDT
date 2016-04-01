# PersianDT
>PesianDate for JAVA :date:

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

you can use use it any where JDK Rnning **Android** or **JAVAEE** or **JAVASE** or whatEver so lets see what PersianDT 
<br/>can do :

* can create dates direclty from System 
* can Create dates from Given date
* You can put anywhere in the string you want
  * Paragrph
  * Sentence
  * WebPage
  * WhatEver
* Can Custom your date if you want
* Can you use MarkDown `{DATE}`to Specified where you want date to be displayed - Text/String

....

##Asynchronous Response :

so if you wanna get reponse Asynchronous You have to use `CallBack Interface` and for using it you have to know how 
in PersianDt you can fill and get response in couple of ways like :



#### Initializing :

#####you can use Builder Pattern Style :

```Java
 PersianDT
    .Instance()
    .Current("Current persian date in your device is {DATE} witout year.")
    .CallBack(this)
    .WithoutYear();

```

you can see full Example in [here](https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/current/useItEasyWayLikeBuilderpattern.java#L56-L60) 
  

