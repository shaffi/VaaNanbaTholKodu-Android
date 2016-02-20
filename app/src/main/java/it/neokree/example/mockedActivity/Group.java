package it.neokree.example.mockedActivity;

import java.util.ArrayList;

/**
 * Created by venkateswaran on 11/2/16.
 */
public class Group {
    private String name;
    private String text1;
    private String image;
    private ArrayList<Child> Items;

    private boolean checked;
    private ArrayList<Child> children;



    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getText1()
    {
        return text1;
    }

    public void setText1(String text1)
    {
        this.text1 = text1;
    }


    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }


    public ArrayList<Child> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Child> Items) {
        this.Items = Items;
    }


    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }
}
