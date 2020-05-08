package org.mvnsearch;

import org.joor.CompileOptions;
import org.joor.Reflect;
import org.joor.ReflectException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * MappingProcessor test
 *
 * @author linux_china
 */
public class MappingProcessorTest {

    @Test
    public void testCompileWithAnnotationProcessors() {
        MappingProcessor p = new MappingProcessor();
        try {
            //language=java
            String code = "package org.mvnsearch;\n" +
                    "import org.mvnsearch.Mapping;\n" +
                    "\n" +
                    "@Mapping(\"demo\")\n" +
                    "public class Demo2 {\n" +
                    "}\n";
            Object o = Reflect.compile("org.mvnsearch.Demo2", code,
                    new CompileOptions().processors(p)
            ).create().get();
            System.out.println(o.getClass());
        } catch (ReflectException expected) {
            assertTrue(p.processed);
        }
    }
}
