package ru.ilyafilim.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import ru.ilyafilim.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@PropertySource("classpath:app.properties")
public class QuestionDaoCSV implements QuestionDao {

    @Value("${csv.ru.testing.file}")
    private String csvFile;
    private int currentRow = 0;

    @Override
    public Question readRow() {
        try {
            currentRow++;
            InputStream in = getClass().getResourceAsStream(csvFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line; int c = 0;
            while ((line = br.readLine()) != null) {
                if (c == currentRow) {
                    return new Question(line.split(",", 2)[0], line.split(",", 2)[1]);
                }
                c++;
            }
        } catch (IOException io) {
            return null;
        }
        return null;
    }
}
