import static java.lang.String.format;

public class Markdown {

    String parse(String input) {

        String[] lines = input.split("\n");
        String html = "";
        boolean inList = false;

        for (String line : lines) {
            line = header(line);

            if (line.matches("(<li>).+") && !inList) {
                inList = true;
                html += "<ul>" + line;
            }
            else if (!line.matches("(<li>).*") && inList) {
                inList = false;
                html += "</ul>" + line;
            }
            else {
                html += line;
            }
        }

        if (inList) {
            html += "</ul>";
        }

        return html;
    }

    private String header(String input) {
        int headerTags = -1;
        String html = "";
        while (input.charAt(++headerTags) == '#') {
            continue;
        } 
        html = headerTags == 0          ?
               listItem(input) :
               format("<h%d>%s</h%d>", 
                      headerTags, 
                      input.substring(headerTags + 1), 
                      headerTags);
        return html;
    }

    private String listItem(String input) {
        String html = input.startsWith("*") ?
                      "<li>" + 
                      modifiers(input.substring(2)) + 
                      "</li>" :
                      paragraph(input);
        return html;

    }

    private String paragraph(String input) {
        String html = "<p>" + modifiers(input) + "</p>";
        return html; 
    }

    private String modifiers(String input) {
        String html = input
                      .replaceAll("__(.+)__", 
                                  "<strong>$1</strong>")
                      .replaceAll("_(.+)_", 
                                  "<em>$1</em>") ;
        return html;     
    }
}