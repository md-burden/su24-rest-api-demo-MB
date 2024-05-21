package emoji;

import java.util.List;

public class Emoji {
    private String name;
    private String category;
    private  String group;
    private List<String> htmlCode;
    private List<String> unicode;

    Emoji() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setHtmlCode(List<String> htmlCode) {
        this.htmlCode = htmlCode;
    }

    public void setUnicode(List<String> unicode) {
        this.unicode = unicode;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getGroup() {
        return group;
    }

    public List<String> getHtmlCode() {
        return htmlCode;
    }

    public List<String> getUnicode() {
        return unicode;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n Category: %s\n Group: %s\n", name, category, group);
    }
}
