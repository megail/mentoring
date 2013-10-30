package com.epam.mentoring.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Simple hello-world plugin just to show how it works.
 *
 * @author Mikhail_Chen-Len-Son@epam.com
 */
@Mojo(name = "hello-world", defaultPhase = LifecyclePhase.COMPILE)
public class HelloWorldPlugin extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException {
        getLog().info( "Hello, world." );
    }
}
