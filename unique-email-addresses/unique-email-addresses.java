class Solution {
    public int numUniqueEmails(String[] emails) {
        //check for null input 
        if(emails == null || emails.length==0)return 0;
        HashSet<String> hset= new HashSet<>();
        for(String email : emails){
            String key = getEmail(email);
            hset.add(key);
        }
        return hset.size();
    }
    public String getEmail(String email){
        
        if(email == null || email.length() ==0)return "";
        int index = email.indexOf("@");
        String name = email.substring(0,index);
        String domain = email.substring(index);
        name = name.replaceAll("\\.", "");
        if(name.contains("+")){
            int plusIndex = name.indexOf("+");
            name = name.substring(0,plusIndex);
        }
        name += domain;
        return name;
    }
}