package Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UserFileManager {
    public static ArrayList<User> getUsers() throws IOException {
        ArrayList<User> users = new ArrayList<>();
        FileReader fileReader = new FileReader("User.dat");
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();

            while (line != null) {
                StringTokenizer tokenizerUser = new StringTokenizer(line, ",");
                String userName = tokenizerUser.nextToken();
                String password = tokenizerUser.nextToken();

                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                line = bufferedReader.readLine();
                users.add(user);
            }
        }

        return users;
    }

    /**
     * @param newUsers
     * @throws IOException
     */
    public static void saveUsers(ArrayList<User> newUsers) throws IOException {
        FileWriter fileWriter = new FileWriter("User.dat", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (User user : newUsers) {

            bufferedWriter.write(user.toString());
            bufferedWriter.newLine();

        }

        bufferedWriter.close();
        fileWriter.close();

    }

}