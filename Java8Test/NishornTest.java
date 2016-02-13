
import javax.script.*;
import java.io.File;

public class NishornTest {

    public static void main(String... args) throws Exception {
        // new nasho
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
         
        String js;
         
        js = "var map = Array.prototype.map \n";
        js += "var names = [\"john\", \"jerry\", \"bob\"]\n";
        js += "var a = map.call(names, function(name) { return name.length() })\n";
        js += "print(a)";
         
        engine.eval(js);
        
        
        File f = new File("test.txt");
        // expose File object as variable to script
        engine.put("file", f);

        // evaluate a script string. The script accesses "file" 
        // variable and calls method on it
        engine.eval("print(file.getAbsolutePath())");
    }
}