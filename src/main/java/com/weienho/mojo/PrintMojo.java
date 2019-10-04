package com.weienho.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author heweien
 * @date 2019-09-16
 **/
@Mojo(name="print", defaultPhase = LifecyclePhase.CLEAN)
public class PrintMojo extends AbstractMojo {
    @Parameter
    private String message;

    @Parameter
    private List<Integer> idList;

    @Parameter(property = "print.createTime")
    private Date createTime;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        if (Objects.nonNull(idList)) {
            idList.forEach(a -> {
                System.out.print(a + "this is a print mojo" + message + "," + createTime);
                System.out.println();
            });

        }
    }
}
