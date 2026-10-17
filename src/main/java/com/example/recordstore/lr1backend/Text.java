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
    private static final Path DATA_FILE = Paths.get(System.getenv().getOrDefault("DATA_FILE", "data.txt"));
    @PostMapping("/save")
    public String save(@RequestBody String text) throws Exception
    {
        Files.writeString(DATA_FILE, text, StandardCharsets.UTF_8);
        return "back";
    }

    @GetMapping("/read")
    public String read() throws Exception
    {
        if (!Files.exists(DATA_FILE)) return "";
        return Files.readString(DATA_FILE, StandardCharsets.UTF_8);
    }
}
