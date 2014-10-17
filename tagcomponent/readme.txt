tagcomponent
=============

In this project we implemented a solution for the creation of a generic web tags to be used in jsp.


- resources/META-INF
	In the resource tld insert the defition for the generic tag. The name of the tag is "component"
	

- src/com/filippocerfeda/aem/taglib
	ComponentTag.java   ---> It is the class that implement the web tag
	ComponentLogic.java ---> It is the interface for the all tag

- src/com/filippocerfeda/aem/ui/mycomponents/
	LeftNavigation.java ---> an example of a tag
	

- src/com/filippocerfeda/aem/ui/jsp/
	left.jsp  --> the script of a component where is used the tag
	
- Design_ComponentTag.jpg
	UML Model of the componentTag
	
