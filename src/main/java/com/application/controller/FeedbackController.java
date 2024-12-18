package com.application.controller;
import com.application.model.Feedback;
import com.application.services.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // Endpoint to save feedback
    @PostMapping
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    // Endpoint to get feedback by course ID
    @GetMapping("/{courseId}")
    public ResponseEntity<List<Feedback>> getFeedbackByCourseId(@PathVariable String courseId) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByCourseId(courseId);
        return ResponseEntity.ok(feedbackList);
    }
}
