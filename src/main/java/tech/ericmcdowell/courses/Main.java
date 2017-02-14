package tech.ericmcdowell.courses;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import tech.ericmcdowell.courses.model.CourseIdea;
import tech.ericmcdowell.courses.model.CourseIdeaDAO;
import tech.ericmcdowell.courses.model.SimpleCourseIdeaDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

/**
 * Created by eric on 2/13/17.
 */
public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");

        CourseIdeaDAO dao = new SimpleCourseIdeaDAO();

        get("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in",(req, res) ->{
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username");
            model.put("username", username);
            res.cookie("username", username);

            return new ModelAndView(model, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
