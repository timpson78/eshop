package model.items.payloads.REST;


public class CategoryR {

    private int id;

    private int parentId;

    private String name;



    public CategoryR() {

    }

    public CategoryR(int id, int parentId, String name) {
        id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { id = id; }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
