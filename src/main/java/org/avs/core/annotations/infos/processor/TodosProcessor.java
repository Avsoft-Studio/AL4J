package org.avs.core.annotations.infos.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic.Kind;

import org.avs.core.annotations.infos.Todos.Todo;

@SupportedAnnotationTypes(value = { "avs.core.annotations.Todos" })
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class TodosProcessor extends AbstractProcessor{
	@Override
	  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
	    Messager messager = processingEnv.getMessager();
	    
	    messager.printMessage(Kind.NOTE, "Je fais des tests");
	 
	    for (TypeElement te : annotations) {
	      messager.printMessage(Kind.NOTE, "Traitement annotation " 
		    + te.getQualifiedName());
	 
	      for (Element element : roundEnv.getElementsAnnotatedWith(te)) {
	        messager.printMessage(Kind.NOTE, "  Traitement élément " 
			  + element.getSimpleName());
	        Todo todo = element.getAnnotation(Todo.class);
	 
	        if (todo != null) {
	          messager.printMessage(Kind.NOTE, "  affecté le " + todo.assignedDate() 
			    + " a " + todo.assignedTo());
	        }
	      }
	    }
	 
	    return true;
	  }
}
