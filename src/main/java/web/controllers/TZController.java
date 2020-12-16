package web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TZController {
    private final Map<BigInteger, Integer> numberOfRepetitions = new HashMap<>();

    @PostMapping("/rest/")
    public ResponseEntity<Map<BigInteger, Integer>> dataRetrieval(@RequestBody List<BigInteger> numbers) {
        for (BigInteger key : numbers) {
            if (numberOfRepetitions.get(key) == null) {
                numberOfRepetitions.put(key, 1);
            } else {
                int count = numberOfRepetitions.get(key);
                numberOfRepetitions.put(key, count + 1);
            }
        }
        return new ResponseEntity<>(numberOfRepetitions, HttpStatus.OK);
    }
}
