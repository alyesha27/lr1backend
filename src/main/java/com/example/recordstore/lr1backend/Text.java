package com.example.recordstore.lr1backend;


import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*")
public class Text
{
    private static final Path DATA_FILE = Paths.get("text.txt");

    @PostMapping("/save")
    public String save(@RequestBody String text) throws Exception
    {
        Files.writeString(DATA_FILE, text, StandardCharsets.UTF_8);
        return "back";
    }
}