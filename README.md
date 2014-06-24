java-vaadin
===========

Vaadin 7 tryout

# Installation  
  
## Installing on Eclipse IDE  
  
1. download and install Eclipse [http://www.eclipse.org/downloads/](http://www.eclipse.org/downloads/)  
2. download and install Apache Tomcat [http://tomcat.apache.org/](http://tomcat.apache.org/)  
3. (additional) install Firebug plugin for Firefox [https://getfirebug.com/](https://getfirebug.com/)  
4. install Vaadin Plugin for Eclipse  
  - install IvyDE Plugin  
    - Help > Install New Software... > Add...  
    - name: Apache Ivy update
    - location: [http://www.apache.org/dist/ant/ivyde/updatesite](http://www.apache.org/dist/ant/ivyde/updatesite)  
    - proceed the install wizard  
  - install Vaadin Plugin  
    - Help > Install New Software... > Add...  
    - name: Vaadin update  
    - location: [http://vaadin.com/eclipse](http://vaadin.com/eclipse)  
    - proceed the install wizard  
5. add Tomcat Runtime Environment  
  - Eclipse > Preferences > Server > Runtime Environments > Add...  
  - Select "Apache Tomcat v?.0" (i had to use v7.0)
  - proceed the wizard    
  
## Creating a project on Eclipse  
  
1. create new project  
  - File > New Project... > Other... > Vaadin > Vaadin 7 Project > Next  
  - target runtime: Apache Tomcat v7.0 (by default this should be the one added in step 5 of "Installing on Eclipse IDE")  
  - configuration: Vaading 7, Java 6, Servlet 3.0  
  - deployment configuration: Servlet (default)  
  - proceed the wizard  
