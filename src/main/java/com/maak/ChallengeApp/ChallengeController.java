package com.maak.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController // this shows this class is a controller
@RequestMapping ("/challenges")                              //route URl
@CrossOrigin(origins = "http://localhost:3001")
public class ChallengeController {

private  final ChallengeService challengeService;


    public ChallengeController(ChallengeService challengeService) {
     this.challengeService= challengeService;

 }

    @GetMapping  //(for get request) when request comes to this point then this work performed by this method
    public List<Challenge> getAllChallenges(){
        return challengeService.getAllChallenges();  // returns list object and during runtime convert it into JSON on localhost:/8080/challenges

    }



        @PostMapping
        public ResponseEntity<String> addChallenge( @RequestBody Challenge challenge) {
            boolean isChallengeAdded = challengeService.addChallenges(challenge);
            if (isChallengeAdded) {
                return new ResponseEntity<>( "Challenge added successfully",HttpStatus.OK);
            } else {
                return new ResponseEntity<>( "Challenge not added ",
                HttpStatus.NOT_FOUND);
            }

        }
            @GetMapping("/{month}")
           public ResponseEntity <Challenge> getChallenges(@PathVariable String month) {
//     pathvariable is written because in place of febuary we can write feb in localhost so at run time
//            it helps to trace the variables path and after challenges we write{month } which is showing month variable will be track


                Challenge challenge = challengeService.getChallenge(month);  // returns list object and during runtime convert it into JSON on localhost:/8080/challenges

                if (challenge != null) {
                    return new ResponseEntity<>(challenge, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }

       @PutMapping("/{id}")
                public ResponseEntity<String> updateChallenge( @PathVariable Long id, @RequestBody Challenge updateChallenge) {

                 boolean   isChallengeUpdated = challengeService.updateChallenge(id, updateChallenge);
                    if (isChallengeUpdated)
                        return  new ResponseEntity<>("Challenge updated successfully",
                        HttpStatus.OK);
                     else
                        return  new ResponseEntity<>("Challenge not updated ",
                                HttpStatus.NOT_FOUND);

                }

                @DeleteMapping("/{id}")
                public ResponseEntity<String>deleteChallenge(@ PathVariable Long id){
     boolean isChallengeDeleted = challengeService.deleteChallenge(id);
     if(isChallengeDeleted)
         return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
     else return new ResponseEntity<>("Challenge not deleted ", HttpStatus.NOT_FOUND);
                }




}

