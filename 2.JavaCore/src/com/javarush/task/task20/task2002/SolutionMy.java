package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush

Рабочий вариант ... не понимаю почему не проходит ...
хотя все тесты ОК

валидатор хотел проверку на пустые параметры имя и фамилия
*/
public class SolutionMy {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("d:\\your_file_name", null);
            File your_file_name = new File ("d:\\your_file_name");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            //System.out.println(javaRush.equals(loadedObject));

            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
                if(!this.users.isEmpty())
                printWriter.println(this.users.size());
                else printWriter.println("0");
            if(this.users.size() > 0) {
                for (User user : users){
                    //printWriter.println(user);


                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    printWriter.println(simpleDateFormat.format(user.getBirthDate()));
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                }
            }
            printWriter.close();
        }
        /*
        private String firstName;
        private String lastName;
        private Date birthDate;
        private boolean isMale;
        private Country country;
                     */
        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int size = Integer.parseInt(reader.readLine());
            if(size!=0){
                for (int i = 0; i < size; i++) {
                    User user = new User();
                    //String fn = reader.readLine();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    //user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    user.setBirthDate(simpleDateFormat.parse(reader.readLine()));
                    String iM = reader.readLine();
                    if (iM.equals("true"))user.setMale(true);
                    else user.setMale(false);
                    //user.setMale(Boolean.getBoolean(reader.readLine()));
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    this.users.add(user);
                }
            }else users = new ArrayList<>();
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
