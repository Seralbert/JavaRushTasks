package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

/*

 */
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("you_file_name", null);
            System.out.println(your_file_name.getAbsolutePath());
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            /*PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.name);
            String isAssetsPresents = assets != null ? "yes" : "no";
            if(assets!=null) {
                printWriter.println(isAssetsPresents);
                printWriter.println(assetsToString(this.assets));
                //printWriter.println(this.assets);

            } else printWriter.println(isAssetsPresents);
            printWriter.flush();*/

            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.name);
            if (this.assets.size() > 0) {
                for (Asset current : this.assets)
                    printWriter.println(current.getName());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            /*BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            name = reader.readLine();
            //String isAssetsPresents;
            if(reader.readLine().equals("yes"))stringToAssets(reader.readLine());
            else assets = null;*/
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            this.name = reader.readLine();
            String assetName;
            while ((assetName = reader.readLine()) != null)
                this.assets.add(new Asset(assetName));
            reader.close();
        }
       /* public String assetsToString(List<Asset> assets){
            String result = "";
            for (Asset a : assets){
                String price;
                if(a.getPrice()==0.0)price = "0.0";
                else price = String.valueOf(a.getPrice());
                result += "!" + a.getName()+ "," + price;
            }
            return result.substring(1);
        }
        public void stringToAssets(String s){
            String[] asset = s.split("!");

            for (String i : asset){
                String[] item = i.split(",");
                Asset a = new Asset(item[0]);
                a.setPrice(Double.parseDouble(item[1]));
                assets.add(a);
            }
        }*/
    }
}
