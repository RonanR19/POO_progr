package br.com.listaligada.model;

public class Sistema {

    private String name;
    private String ext;
    private long   size;
    private int posicao ;
    Location loc = new Location(124,null);


    public Sistema(int posicao,String name, String ext, long size, Location loc) {
        super();
        this.posicao = posicao;
        this.name = name;
        this.ext = ext;
        this.size = size;
        this.loc = loc;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getSize() {
        return size;
    }
    public void setSize(long size) {
        this.size = size;
    }

    public String getExt() {
        return ext;
    }
    public void setExt(String ext) {
        this.ext = ext;
    }

    public int getPosicao() {
        return posicao;
    }
    public void setPosição(int posição) {
        this.posicao = posicao;
    }
    @Override
    public String toString() {
        return  posicao +"\t"+ name +"."+ ext+ "\t" +  size + "\t" + loc
                + "\n";
    }


}
