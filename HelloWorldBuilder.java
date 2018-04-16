package io.jenkins.plugins.sample;

import java.util.Scanner;

import hudson.Launcher;
import hudson.Extension;
import hudson.FilePath;
import hudson.util.FormValidation;
import hudson.model.AbstractProject;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.Builder;
import hudson.tasks.BuildStepDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import javax.servlet.ServletException;
import java.io.IOException;
import jenkins.tasks.SimpleBuildStep;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundSetter;

public class HelloWorldBuilder extends Builder implements SimpleBuildStep {

    private final String name;

    @DataBoundConstructor
    public HelloWorldBuilder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public static String calculate(String[] args) {

        Scanner input = new Scanner(System.in);

        maths Maths = new maths();

        double zeroAnswer = 0; //Possible refactor needed here at some point
        double negAnswer = 0; //Change variable names
        double posAnswer = 0;
        int randAnswer = 0;
        boolean positive = false;
        double inputA, inputB, inputVar, inputEq;
        char inputStr;
        char operator;
        boolean done = false;

         while (done == false) {
        	positive = false;
            randAnswer = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

            inputA = input.next().charAt(0);
            inputA = 0;
            operator = input.next().charAt(0);
            inputB = input.nextDouble();        
            switch (operator) {
                case '+': {
                			zeroAnswer = Maths.subtract(inputA, inputB);
                			negAnswer = zeroAnswer + 1; 
                }
                          break;
                case '-': {
                			zeroAnswer = Maths.add(inputA, inputB);
                			negAnswer = zeroAnswer - 1;
                }
                          break;
                case '*': {
                			zeroAnswer = Maths.divide(inputA, inputB);
                			negAnswer = -1;
                }
                          break;
                case '/': {
                			zeroAnswer = Maths.multiply(inputA, inputB);
                			negAnswer = -1;
                }
                          break;
                case '^': {
                			zeroAnswer = Maths.power(inputA, inputB);
                			negAnswer = 1;
                }
                		  break;
                case '>': {
                			zeroAnswer = inputB;
                			negAnswer = inputB - 1;
                			posAnswer = inputB + 1;
                			positive = true;
                }
                		  break;
                case '<': {
                			zeroAnswer = inputB;
                			negAnswer = inputB + 1;
                			posAnswer = inputB - 1;
                			positive = true;
                }
                		  break;
                
            }
            
            	System.out.print("Possible edge cases for " + inputStr + " are: ");
            	if(!positive)
            	{
            		String result = (Double.toString(zeroAnswer) + ',' + Double.toString(negAnswer) + ',' + Integer.toString(randAnswer));   
            	}
            	else 
            	{
            		String result = (Double.toString(zeroAnswer) + ',' + Double.toString(negAnswer) + ',' + Double.toString(posAnswer) + ',' + Double.toString(randAnswer));
            	}
        }       

        input.close();
        return result;

      }
    
    @Override
    public void perform(Run<?, ?> run, FilePath workspace, Launcher launcher, TaskListener listener) throws InterruptedException, IOException {
    	listener.getLogger().println(calculate(name));
    
    }

    @Symbol("greet")
    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {

        public FormValidation doCheckName(@QueryParameter String value)
                throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error(Messages.HelloWorldBuilder_DescriptorImpl_errors_missingName());
            if (value.length() < 4)
                return FormValidation.warning(Messages.HelloWorldBuilder_DescriptorImpl_warnings_tooShort());
            return FormValidation.ok();
        }

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return Messages.HelloWorldBuilder_DescriptorImpl_DisplayName();
        }

    }

}
