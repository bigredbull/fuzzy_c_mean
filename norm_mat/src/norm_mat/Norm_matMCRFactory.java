/*
 * MATLAB Compiler: 4.18.1 (R2013a)
 * Date: Sun Jul 24 23:13:56 2016
 * Arguments: "-B" "macro_default" "-W" "java:norm_mat,NormMatlab" "-T" "link:lib" "-d" 
 * "D:\\Java\\MyWorkspace\\fcm\\norm_mat\\src" "-w" "enable:specified_file_mismatch" "-w" 
 * "enable:repeated_file" "-w" "enable:switch_ignored" "-w" "enable:missing_lib_sentinel" 
 * "-w" "enable:demo_license" "-v" 
 * "class{NormMatlab:D:\\Java\\MyWorkspace\\test\\calNorms.m}" 
 */

package norm_mat;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class Norm_matMCRFactory
{
   
    
    /** Component's uuid */
    private static final String sComponentId = "norm_mat_C08560F1D8A75ABA91ED0E82F13CD5C7";
    
    /** Component name */
    private static final String sComponentName = "norm_mat";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(Norm_matMCRFactory.class)
        );
    
    
    private Norm_matMCRFactory()
    {
        // Never called.
    }
    
    public static MWMCR newInstance(MWComponentOptions componentOptions) throws MWException
    {
        if (null == componentOptions.getCtfSource()) {
            componentOptions = new MWComponentOptions(componentOptions);
            componentOptions.setCtfSource(sDefaultComponentOptions.getCtfSource());
        }
        return MWMCR.newInstance(
            componentOptions, 
            Norm_matMCRFactory.class, 
            sComponentName, 
            sComponentId,
            new int[]{8,1,0}
        );
    }
    
    public static MWMCR newInstance() throws MWException
    {
        return newInstance(sDefaultComponentOptions);
    }
}
