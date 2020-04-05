package ru.ilyafilim.dao;

import ru.ilyafilim.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class QuestionDaoCSV implements QuestionDao {

    private final String csvFile;
    private int currentRow = 0;

    public QuestionDaoCSV(String csvFile) {
        this.csvFile = csvFile;
    }

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
