//package com.moringaschool.petfinder.ui;
//
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public static class Dogs{
//    final FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference ref = database.getReference("server/saving-data/fireblog");
//
//        public String breedName;
//        public String Color;
//        public String name;
//
//        public Dogs(String breedName, String Color) {
//
//         }
//
//        public Dogs(String breedName, String color ,String name) {
//
//        }
//
//
//
//
//
//    DatabaseReference PetTypeRef = ref.child("petType");
//
//    Map<String, Dogs> PetType = new HashMap<>();
//    PetType.put("husky", new Dogs("Siberian husky", "white"));
//    PetType.put("hop", new Dogs("December 9, 1906", "Grace Hopper"));
//
//     PetTypeRef.setValueAsync(Dogs);
//     }
