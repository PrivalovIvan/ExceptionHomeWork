import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUser {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.printf(
                    "Введите следующие данные в произвольном порядке, разделенные пробелом:\nФамилия Имя Отчество\nдата рождения(дд.мм.гггг)\nномертелефона(89123456789)\nпол(m|f)\n:");
            String dataUser = scanner.nextLine();
            String[] arrUserData = dataUser.split(" ");
            if (arrUserData.length == 6) {
                String fullName = findFullName(dataUser);
                String bDay = findBDay(dataUser);
                String gender = findGender(dataUser);
                Long phone = findPhone(dataUser);
                readerFile(nameFile(fullName), bDay, gender, phone, fullName);
            } else if (arrUserData.length > 6) {
                System.out.println("Ввели больше данных, чем нужно");
            } else if (arrUserData.length < 6) {
                System.out.println("Ввели меньше данных, чем нужно");
            }
            scanner.close();
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод номера телефона (89123456789).");
            e.getMessage();
        } catch (IncorrectGenderException e) {
            System.out.println("Некорректно введен пол (f - женский, m - мужской)");
        } catch (IncorrectFIOException e) {
            System.out.println("Некорректно введены ФИО");
        } catch (IncorrectBDayException e) {
            System.out.println("Некорректно введена дата рождения(дд.мм.гггг) ");
        }
    }

    public static String findBDay(String str) {
        String bDay = patternMatcher("\\d{2}\\.\\d{2}\\.\\d{4}", str);
        if (bDay == null) {
            throw new IncorrectBDayException();
        }
        return bDay;
    }

    public static String findGender(String str) {
        String gender = patternMatcher("f|m", str);
        if (gender == null) {
            throw new IncorrectGenderException();
        }
        return gender;
    }

    public static Long findPhone(String str) throws NumberFormatException {
        Long phone = Long.parseLong(patternMatcher("\\d{11}", str));
        return phone;
    }

    public static String findFullName(String str) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z ]{3,}");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        String fullName = sb.toString().replaceAll("\\s+$", "");
        String[] lengthFullName = fullName.split(" ");
        if (lengthFullName.length < 3 || lengthFullName.length > 3) {
            throw new IncorrectFIOException();
        }
        return fullName;
    }

    public static String patternMatcher(String pat, String str) {
        String result = null;
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            return result = matcher.group();
        }
        return result;
    }

    public static String nameFile(String name) {
        String[] fileName = name.split(" ");
        String result = fileName[0] + ".txt";
        return result;
    }

    public static void writeFile(String fileName, String bDay, String gender, Long phone, String fullName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(fullName + " ");
            writer.append(bDay + " ");
            writer.append(phone + " ");
            writer.append(gender + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readerFile(String fileName, String bDay, String gender, Long phone, String fullName) {
        String str = String.format("%s %s %s %s", fullName, bDay, phone, gender);
        boolean flag = true;
        try (FileReader fr = new FileReader(fileName)) {
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                if (line == null || line.equals(str)) {
                    flag = false;
                    break;
                } else
                    line = br.readLine();
            }
            if (flag) {
                writeFile(fileName, bDay, gender, phone, fullName);
            }
        } catch (IOException e) {
            writeFile(fileName, bDay, gender, phone, fullName);
        }
    }
}
