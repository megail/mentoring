package com.epam.mentoring.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates version properties file in the specified directory.
 *
 * @author Mikhail_Chen-Len-Son@epam.com
 */
@Mojo(name = "version-file", defaultPhase = LifecyclePhase.COMPILE)
public class VersionPlugin extends AbstractMojo {

    /**
     * Version to be written in file
     */
    @Parameter
    private String version;

    /**
     * Name of the file
     */
    @Parameter
    private String fileName;

    /**
     * Directory where to save properties file.
     */
    @Parameter
    private String resourceRoot;

    @Override
    public void execute() throws MojoExecutionException {
        try {
            File file = new File(resourceRoot + File.separator + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(version);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getLog().info("Created version file.");
    }
}
