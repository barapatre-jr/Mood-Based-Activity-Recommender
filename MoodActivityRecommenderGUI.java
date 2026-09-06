import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

// ---------------- ENUM ----------------
enum Mood {
    HAPPY("Happy", "\uD83D\uDE0A", new Color(255, 214, 92), new Color(110, 80, 0)),
    SAD("Sad", "\uD83D\uDE22", new Color(150, 190, 255), new Color(20, 40, 90)),
    STRESSED("Stressed", "\uD83D\uDE23", new Color(255, 150, 140), new Color(100, 25, 20)),
    BORED("Bored", "\uD83D\uDE10", new Color(200, 200, 205), new Color(50, 50, 55)),
    ANGRY("Angry", "\uD83D\uDE20", new Color(255, 110, 110), new Color(100, 15, 15)),
    ANXIOUS("Anxious", "\uD83D\uDE30", new Color(210, 175, 255), new Color(65, 20, 95)),
    TIRED("Tired", "\uD83D\uDE34", new Color(170, 205, 225), new Color(20, 55, 65)),
    ENERGETIC("Energetic", "\u26A1", new Color(255, 195, 95), new Color(105, 60, 0));

    private final String label;
    private final String emoji;
    private final Color bgColor;
    private final Color fgColor;

    Mood(String label, String emoji, Color bgColor, Color fgColor) {
        this.label = label;
        this.emoji = emoji;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
    }

    public String getLabel() { return label; }
    public String getEmoji() { return emoji; }
    public Color getBgColor() { return bgColor; }
    public Color getFgColor() { return fgColor; }
}

// ---------------- INTERFACE (Abstraction) ----------------
interface Recommendable {
    List<Activity> getRecommendations(Mood mood);
}

// ---------------- ABSTRACT CLASS ----------------
abstract class Activity {
    private final String name;
    private final String description;
    private final int durationMinutes;
    private final String category;

    public Activity(String name, String description, int durationMinutes, String category) {
        this.name = name;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.category = category;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getDurationMinutes() { return durationMinutes; }
    public String getCategory() { return category; }

    public abstract String performActivity();
}

// ---------------- SUBCLASSES (Inheritance + Polymorphism) ----------------
class PhysicalActivity extends Activity {
    public PhysicalActivity(String name, String description, int durationMinutes) {
        super(name, description, durationMinutes, "Physical");
    }
    @Override
    public String performActivity() {
        return "Get moving! Stretch a little before you start \"" + getName() + "\".";
    }
}

class CreativeActivity extends Activity {
    public CreativeActivity(String name, String description, int durationMinutes) {
        super(name, description, durationMinutes, "Creative");
    }
    @Override
    public String performActivity() {
        return "Let your imagination flow while you enjoy \"" + getName() + "\".";
    }
}

class RelaxationActivity extends Activity {
    public RelaxationActivity(String name, String description, int durationMinutes) {
        super(name, description, durationMinutes, "Relaxation");
    }
    @Override
    public String performActivity() {
        return "Take a deep breath and slowly ease into \"" + getName() + "\".";
    }
}

class SocialActivity extends Activity {
    public SocialActivity(String name, String description, int durationMinutes) {
        super(name, description, durationMinutes, "Social");
    }
    @Override
    public String performActivity() {
        return "Reach out and enjoy \"" + getName() + "\" with someone else.";
    }
}

class MentalActivity extends Activity {
    public MentalActivity(String name, String description, int durationMinutes) {
        super(name, description, durationMinutes, "Mental");
    }
    @Override
    public String performActivity() {
        return "Sharpen your mind with \"" + getName() + "\".";
    }
}

// ---------------- RECOMMENDATION ENGINE ----------------
class ActivityRecommenderEngine implements Recommendable {
    private final Map<Mood, List<Activity>> moodActivityMap = new EnumMap<>(Mood.class);
    private final Random random = new Random();

    public ActivityRecommenderEngine() {
        populateData();
    }

    private void populateData() {
        moodActivityMap.put(Mood.HAPPY, Arrays.asList(
                new SocialActivity("Call a Friend", "Share your good mood with someone you love.", 20),
                new CreativeActivity("Dance it Out", "Play your favorite song and dance freely.", 15),
                new PhysicalActivity("Go for a Jog", "Channel your energy into a refreshing run.", 30),
                new SocialActivity("Plan a Small Celebration", "Treat yourself or a loved one to a mini celebration.", 25)
        ));

        moodActivityMap.put(Mood.SAD, Arrays.asList(
                new RelaxationActivity("Watch a Comfort Movie", "Rewatch a movie that always cheers you up.", 90),
                new SocialActivity("Talk to a Loved One", "Open up to someone you trust.", 25),
                new CreativeActivity("Write a Journal Entry", "Pour your thoughts onto paper.", 15),
                new RelaxationActivity("Listen to Uplifting Music", "Play a playlist that usually lifts your spirits.", 15)
        ));

        moodActivityMap.put(Mood.STRESSED, Arrays.asList(
                new RelaxationActivity("Meditate", "Sit quietly and focus on your breathing.", 10),
                new PhysicalActivity("Take a Walk", "A short walk outside can clear your head.", 20),
                new RelaxationActivity("Listen to Calm Music", "Play soft instrumental music.", 15),
                new RelaxationActivity("Progressive Muscle Relaxation", "Tense and release each muscle group slowly.", 12)
        ));

        moodActivityMap.put(Mood.BORED, Arrays.asList(
                new MentalActivity("Solve a Puzzle", "Try a crossword or sudoku puzzle.", 20),
                new CreativeActivity("Try a New Recipe", "Cook something you've never made before.", 40),
                new MentalActivity("Learn Something New", "Watch a short tutorial on a topic you like.", 25),
                new PhysicalActivity("Reorganize a Small Space", "Tidy a drawer, desk or shelf for quick satisfaction.", 25)
        ));

        moodActivityMap.put(Mood.ANGRY, Arrays.asList(
                new PhysicalActivity("Hit the Gym", "Release your anger through exercise.", 45),
                new RelaxationActivity("Deep Breathing Exercise", "Inhale for 4 counts, hold, exhale for 4 counts.", 5),
                new CreativeActivity("Draw it Out", "Express your anger creatively on paper.", 10),
                new PhysicalActivity("Brisk Walk", "Walk it off outside to cool down.", 15)
        ));

        moodActivityMap.put(Mood.ANXIOUS, Arrays.asList(
                new RelaxationActivity("Guided Meditation", "Follow a calming guided meditation session.", 15),
                new MentalActivity("5-4-3-2-1 Grounding", "Name 5 things you see, 4 you feel, 3 you hear, 2 you smell, 1 you taste.", 5),
                new SocialActivity("Talk to Someone Supportive", "Reassurance from a trusted person can help.", 20),
                new MentalActivity("Write Down Your Worries", "Getting anxious thoughts onto paper can lessen their grip.", 10)
        ));

        moodActivityMap.put(Mood.TIRED, Arrays.asList(
                new RelaxationActivity("Take a Power Nap", "A short 20-minute nap can restore energy.", 20),
                new RelaxationActivity("Stretch Gently", "Do light stretches to ease tension.", 10),
                new RelaxationActivity("Sip Herbal Tea", "Relax with a warm cup of tea.", 10),
                new RelaxationActivity("Quick Breathing Reset", "A few slow breaths can help you feel more alert.", 5)
        ));

        moodActivityMap.put(Mood.ENERGETIC, Arrays.asList(
                new PhysicalActivity("Workout Session", "Use that energy for a full workout.", 45),
                new SocialActivity("Plan an Outing", "Organize a fun trip or hangout with friends.", 30),
                new CreativeActivity("Start a New Project", "Channel your energy into something productive.", 60),
                new MentalActivity("Learn a New Skill", "Pick up something new, like a language or instrument.", 40)
        ));
    }

    @Override
    public List<Activity> getRecommendations(Mood mood) {
        List<Activity> activities = new ArrayList<>(moodActivityMap.get(mood));
        Collections.shuffle(activities);
        return activities;
    }

    public Activity getRandomActivity(Mood mood) {
        List<Activity> activities = moodActivityMap.get(mood);
        return activities.get(random.nextInt(activities.size()));
    }
}

// ---------------- HISTORY & JOURNAL ENTRIES + USER ----------------
class HistoryEntry {
    private final Mood mood;
    private final String activityName;
    private final String time;

    public HistoryEntry(Mood mood, String activityName) {
        this.mood = mood;
        this.activityName = activityName;
        this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    public Mood getMood() { return mood; }
    public String getActivityName() { return activityName; }
    public String getTime() { return time; }
}

class JournalEntry {
    private final String timestamp;
    private final String text;

    public JournalEntry(String text) {
        this.text = text;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a"));
    }

    public String getTimestamp() { return timestamp; }
    public String getText() { return text; }
}

class User {
    private final String username;
    private final String password;
    private final List<HistoryEntry> history = new ArrayList<>();
    private final List<JournalEntry> journalEntries = new ArrayList<>();
    private final List<String> feedbacks = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public boolean validatePassword(String pass) { return this.password.equals(pass); }

    public void addToHistory(Mood mood, String activityName) {
        history.add(new HistoryEntry(mood, activityName));
    }

    public List<HistoryEntry> getHistory() { return history; }

    public void addJournalEntry(String text) {
        journalEntries.add(new JournalEntry(text));
    }

    public List<JournalEntry> getJournalEntries() { return journalEntries; }

    public void addFeedback(String feedback) {
        feedbacks.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a")) + " - " + feedback);
    }

    public List<String> getFeedbacks() { return feedbacks; }
}

// ---------------- CUSTOM ROUNDED SWING COMPONENTS ----------------
class RoundedPanel extends JPanel {
    private final int radius;
    private final Color bgColor;

    public RoundedPanel(int radius, Color bgColor) {
        this.radius = radius;
        this.bgColor = bgColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
        super.paintComponent(g);
    }
}

class RoundedButton extends JButton {
    private final int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color base = getBackground();
        g2.setColor(getModel().isRollover() ? base.darker() : base);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
        super.paintComponent(g);
    }
}

// ---------------- AUTHENTICATION DIALOG ----------------
class AuthDialog extends JDialog {
    private final Map<String, User> userDatabase;
    private User authenticatedUser = null;

    private final JTextField userField = new JTextField(15);
    private final JPasswordField passField = new JPasswordField(15);

    public AuthDialog(JFrame parent, Map<String, User> userDatabase) {
        super(parent, "Login / Register", true);
        this.userDatabase = userDatabase;

        setSize(360, 240);
        setLocationRelativeTo(parent);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 10, 25));

        formPanel.add(new JLabel("Username:"));
        formPanel.add(userField);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passField);

        RoundedButton loginBtn = new RoundedButton("Login", 12);
        loginBtn.setBackground(new Color(80, 130, 255));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addActionListener(e -> handleLogin());

        RoundedButton regBtn = new RoundedButton("Register", 12);
        regBtn.setBackground(new Color(70, 190, 120));
        regBtn.setForeground(Color.WHITE);
        regBtn.addActionListener(e -> handleRegister());

        formPanel.add(loginBtn);
        formPanel.add(regBtn);

        JLabel header = new JLabel("Welcome! Please Login or Register", SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBorder(BorderFactory.createEmptyBorder(15, 10, 5, 10));

        add(header, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
    }

    private void handleLogin() {
        String u = userField.getText().trim();
        String p = new String(passField.getPassword()).trim();

        if (u.isEmpty() || p.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        User user = userDatabase.get(u);
        if (user != null && user.validatePassword(p)) {
            authenticatedUser = user;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleRegister() {
        String u = userField.getText().trim();
        String p = new String(passField.getPassword()).trim();

        if (u.isEmpty() || p.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        if (userDatabase.containsKey(u)) {
            JOptionPane.showMessageDialog(this, "Username already exists!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        User newUser = new User(u, p);
        userDatabase.put(u, newUser);
        authenticatedUser = newUser;
        JOptionPane.showMessageDialog(this, "Registration Successful! Logged in as " + u);
        dispose();
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }
}


// ---------------- MOOD ASSESSMENT RESULT ----------------
class MoodAssessmentResult {
    private final Mood mood;
    private final Map<Mood, Integer> scores;
    private final List<String> reasons;

    public MoodAssessmentResult(Mood mood, Map<Mood, Integer> scores, List<String> reasons) {
        this.mood = mood;
        this.scores = new EnumMap<>(scores);
        this.reasons = new ArrayList<>(reasons);
    }

    public Mood getMood() { return mood; }
    public Map<Mood, Integer> getScores() { return scores; }
    public List<String> getReasons() { return reasons; }
}

// ---------------- QUESTION-BASED MOOD ASSESSMENT ----------------
class MoodAssessmentEngine {
    public MoodAssessmentResult analyze(int[] answers) {
        Map<Mood, Integer> score = new EnumMap<>(Mood.class);
        for (Mood mood : Mood.values()) score.put(mood, 0);
        List<String> reasons = new ArrayList<>();

        // Q1: overall feeling (1=positive ... 5=negative)
        switch (answers[0]) {
            case 1 -> { score.merge(Mood.HAPPY, 4, Integer::sum); score.merge(Mood.ENERGETIC, 2, Integer::sum); reasons.add("You described your overall feeling as positive."); }
            case 2 -> score.merge(Mood.HAPPY, 2, Integer::sum);
            case 3 -> score.merge(Mood.BORED, 2, Integer::sum);
            case 4 -> { score.merge(Mood.SAD, 3, Integer::sum); score.merge(Mood.STRESSED, 2, Integer::sum); }
            case 5 -> { score.merge(Mood.SAD, 4, Integer::sum); score.merge(Mood.ANXIOUS, 2, Integer::sum); reasons.add("Your overall feeling suggests you may need emotional support or relaxation."); }
        }

        // Q2: energy
        switch (answers[1]) {
            case 1 -> { score.merge(Mood.ENERGETIC, 4, Integer::sum); reasons.add("You reported high energy."); }
            case 2 -> score.merge(Mood.HAPPY, 2, Integer::sum);
            case 3 -> score.merge(Mood.BORED, 1, Integer::sum);
            case 4 -> { score.merge(Mood.TIRED, 3, Integer::sum); reasons.add("Your energy level is low."); }
            case 5 -> { score.merge(Mood.TIRED, 5, Integer::sum); reasons.add("You reported very low energy."); }
        }

        // Q3: stress
        switch (answers[2]) {
            case 1 -> score.merge(Mood.HAPPY, 2, Integer::sum);
            case 2 -> score.merge(Mood.HAPPY, 1, Integer::sum);
            case 3 -> score.merge(Mood.BORED, 1, Integer::sum);
            case 4 -> { score.merge(Mood.STRESSED, 3, Integer::sum); reasons.add("You reported a high level of stress."); }
            case 5 -> { score.merge(Mood.STRESSED, 5, Integer::sum); score.merge(Mood.ANXIOUS, 2, Integer::sum); reasons.add("You reported very high stress."); }
        }

        // Q4: sleep
        switch (answers[3]) {
            case 1 -> score.merge(Mood.ENERGETIC, 2, Integer::sum);
            case 2 -> score.merge(Mood.HAPPY, 1, Integer::sum);
            case 3 -> score.merge(Mood.TIRED, 1, Integer::sum);
            case 4 -> { score.merge(Mood.TIRED, 3, Integer::sum); reasons.add("Your sleep quality may be affecting your energy."); }
            case 5 -> { score.merge(Mood.TIRED, 4, Integer::sum); score.merge(Mood.STRESSED, 1, Integer::sum); reasons.add("Poor sleep can contribute to tiredness."); }
        }

        // Q5: concentration
        switch (answers[4]) {
            case 1 -> score.merge(Mood.ENERGETIC, 2, Integer::sum);
            case 2 -> score.merge(Mood.HAPPY, 1, Integer::sum);
            case 3 -> score.merge(Mood.BORED, 1, Integer::sum);
            case 4 -> { score.merge(Mood.STRESSED, 2, Integer::sum); score.merge(Mood.ANXIOUS, 2, Integer::sum); reasons.add("You are having difficulty concentrating."); }
            case 5 -> { score.merge(Mood.ANXIOUS, 4, Integer::sum); score.merge(Mood.STRESSED, 3, Integer::sum); reasons.add("You reported serious difficulty concentrating."); }
        }

        // Q6: social preference
        switch (answers[5]) {
            case 1 -> { score.merge(Mood.HAPPY, 2, Integer::sum); score.merge(Mood.ENERGETIC, 1, Integer::sum); }
            case 2 -> score.merge(Mood.HAPPY, 1, Integer::sum);
            case 3 -> score.merge(Mood.BORED, 1, Integer::sum);
            case 4 -> { score.merge(Mood.SAD, 2, Integer::sum); score.merge(Mood.TIRED, 1, Integer::sum); }
            case 5 -> { score.merge(Mood.SAD, 3, Integer::sum); score.merge(Mood.ANXIOUS, 1, Integer::sum); reasons.add("You prefer to be alone right now."); }
        }

        // Q7: physical feeling
        switch (answers[6]) {
            case 1 -> score.merge(Mood.ENERGETIC, 3, Integer::sum);
            case 2 -> score.merge(Mood.HAPPY, 1, Integer::sum);
            case 3 -> score.merge(Mood.BORED, 1, Integer::sum);
            case 4 -> { score.merge(Mood.TIRED, 3, Integer::sum); reasons.add("You are physically tired."); }
            case 5 -> { score.merge(Mood.TIRED, 5, Integer::sum); reasons.add("You reported feeling very physically tired."); }
        }

        // Q8: immediate need
        switch (answers[7]) {
            case 1 -> { score.merge(Mood.ENERGETIC, 3, Integer::sum); score.merge(Mood.HAPPY, 1, Integer::sum); }
            case 2 -> score.merge(Mood.HAPPY, 2, Integer::sum);
            case 3 -> score.merge(Mood.BORED, 3, Integer::sum);
            case 4 -> { score.merge(Mood.STRESSED, 2, Integer::sum); score.merge(Mood.TIRED, 1, Integer::sum); }
            case 5 -> { score.merge(Mood.SAD, 2, Integer::sum); score.merge(Mood.ANXIOUS, 2, Integer::sum); }
        }

        Mood best = Mood.HAPPY;
        int bestScore = Integer.MIN_VALUE;
        for (Mood mood : Mood.values()) {
            if (score.get(mood) > bestScore) {
                bestScore = score.get(mood);
                best = mood;
            }
        }
        if (reasons.isEmpty()) reasons.add("Your answers were balanced, so the highest-scoring mood was selected.");
        return new MoodAssessmentResult(best, score, reasons);
    }
}

// ---------------- MOOD ASSESSMENT PAGE ----------------
class MoodAssessmentPage extends JDialog {
    private final JFrame parent;
    private final ActivityRecommenderEngine engine;
    private final User user;
    private final ButtonGroup[] groups = new ButtonGroup[8];
    private final JRadioButton[][] options = new JRadioButton[8][5];

    private final String[] questions = {
            "How would you describe your overall feeling right now?",
            "How energetic do you feel at the moment?",
            "How stressed do you feel right now?",
            "How was your sleep recently?",
            "How difficult is it to concentrate right now?",
            "What do you prefer right now?",
            "How does your body feel physically?",
            "What would help you most right now?"
    };

    private final String[][] answers = {
            {"Very positive", "Positive", "Neutral", "Negative", "Very negative"},
            {"Very energetic", "Energetic", "Normal", "Low energy", "Exhausted"},
            {"Not stressed", "Slightly stressed", "Moderately stressed", "Very stressed", "Extremely stressed"},
            {"Very good", "Good", "Average", "Poor", "Very poor"},
            {"Very easy", "Easy", "Normal", "Difficult", "Very difficult"},
            {"Be with friends", "Talk to someone", "No preference", "Some alone time", "Be completely alone"},
            {"Fresh and active", "Comfortable", "Normal", "Physically tired", "Very tired"},
            {"Do something active", "Relax", "Try something new", "Reduce stress", "Feel emotionally better"}
    };

    public MoodAssessmentPage(JFrame parent, ActivityRecommenderEngine engine, User user) {
        super(parent, "Mood Assessment", true);
        this.parent = parent;
        this.engine = engine;
        this.user = user;
        setSize(720, 720);
        setLocationRelativeTo(parent);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        buildUI();
    }

    private void buildUI() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBackground(Color.WHITE);
        root.setBorder(BorderFactory.createEmptyBorder(15, 18, 15, 18));

        JLabel title = new JLabel("Let's understand your mood", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        JLabel subtitle = new JLabel("Answer honestly. Your responses will be analyzed to predict a mood and recommend activities.", SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitle.setForeground(Color.GRAY);
        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBackground(Color.WHITE);
        header.add(title);
        header.add(subtitle);
        root.add(header, BorderLayout.NORTH);

        JPanel questionPanel = new JPanel();
        questionPanel.setBackground(Color.WHITE);
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < questions.length; i++) {
            JPanel qPanel = new JPanel();
            qPanel.setBackground(new Color(247, 248, 251));
            qPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(225, 227, 232)),
                    BorderFactory.createEmptyBorder(8, 10, 8, 10)));
            qPanel.setLayout(new BorderLayout(5, 5));
            JLabel q = new JLabel((i + 1) + ". " + questions[i]);
            q.setFont(new Font("Segoe UI", Font.BOLD, 12));
            qPanel.add(q, BorderLayout.NORTH);

            JPanel answerPanel = new JPanel(new GridLayout(1, 5, 5, 5));
            answerPanel.setBackground(new Color(247, 248, 251));
            groups[i] = new ButtonGroup();
            for (int j = 0; j < 5; j++) {
                JRadioButton rb = new JRadioButton("" + (j + 1) + ". " + answers[i][j]);
                rb.setFont(new Font("Segoe UI", Font.PLAIN, 10));
                rb.setBackground(new Color(247, 248, 251));
                rb.setToolTipText(answers[i][j]);
                groups[i].add(rb);
                options[i][j] = rb;
                answerPanel.add(rb);
            }
            qPanel.add(answerPanel, BorderLayout.CENTER);
            questionPanel.add(qPanel);
            questionPanel.add(Box.createVerticalStrut(7));
        }

        JScrollPane scroll = new JScrollPane(questionPanel);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(14);
        root.add(scroll, BorderLayout.CENTER);

        RoundedButton analyzeBtn = new RoundedButton("Analyze My Mood", 16);
        analyzeBtn.setBackground(new Color(80, 130, 255));
        analyzeBtn.setForeground(Color.WHITE);
        analyzeBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        analyzeBtn.setPreferredSize(new Dimension(190, 42));
        analyzeBtn.addActionListener(e -> analyze());

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.add(analyzeBtn);
        root.add(bottom, BorderLayout.SOUTH);
        setContentPane(root);
    }

    private void analyze() {
        int[] selected = new int[8];
        for (int i = 0; i < 8; i++) {
            selected[i] = 0;
            for (int j = 0; j < 5; j++) {
                if (options[i][j].isSelected()) {
                    selected[i] = j + 1;
                    break;
                }
            }
            if (selected[i] == 0) {
                JOptionPane.showMessageDialog(this, "Please answer question " + (i + 1) + " before continuing.", "Incomplete Assessment", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        MoodAssessmentEngine assessmentEngine = new MoodAssessmentEngine();
        MoodAssessmentResult result = assessmentEngine.analyze(selected);
        showResult(result);
    }

    private void showResult(MoodAssessmentResult result) {
        StringBuilder message = new StringBuilder();
        message.append("<html><div style='width:560px;'>");
        message.append("<h2>").append(result.getMood().getEmoji()).append(" Predicted Mood: ").append(result.getMood().getLabel()).append("</h2>");
        message.append("<p><b>Why this mood was selected:</b></p><ul>");
        for (String reason : result.getReasons()) message.append("<li>").append(reason).append("</li>");
        message.append("</ul><p><b>Decision scores:</b><br>");
        for (Mood mood : Mood.values()) message.append(mood.getLabel()).append(": ").append(result.getScores().get(mood)).append(" &nbsp; ");
        message.append("</p></div></html>");

        int choice = JOptionPane.showOptionDialog(this, message.toString(), "Mood Analysis Result", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Show Recommendations", "Close"}, "Show Recommendations");
        if (choice == 0) {
            dispose();
            new RecommendationPage(parent, engine, user, result.getMood()).setVisible(true);
        }
    }
}

// ---------------- RECOMMENDATION POP-UP PAGE ----------------
class RecommendationPage extends JDialog {
    private final ActivityRecommenderEngine engine;
    private final User user;
    private final Mood mood;
    private Activity currentPick;

    private JLabel pickNameLabel;
    private JLabel pickMetaLabel;
    private JLabel pickMessageLabel;

    public RecommendationPage(JFrame parent, ActivityRecommenderEngine engine, User user, Mood mood) {
        super(parent, mood.getLabel() + " Activities", true);
        this.engine = engine;
        this.user = user;
        this.mood = mood;
        this.currentPick = engine.getRandomActivity(mood);

        setSize(480, 650);
        setLocationRelativeTo(parent);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        add(buildHeader(), BorderLayout.NORTH);
        add(buildBody(), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
    }

    private JPanel buildHeader() {
        JPanel header = new JPanel();
        header.setBackground(mood.getBgColor());
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBorder(BorderFactory.createEmptyBorder(25, 20, 20, 20));

        JLabel emojiLabel = new JLabel(mood.getEmoji());
        emojiLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 38));
        emojiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Feeling " + mood.getLabel() + "?");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(mood.getFgColor());
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subLabel = new JLabel("Here is what we recommend for you");
        subLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subLabel.setForeground(mood.getFgColor());
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(emojiLabel);
        header.add(Box.createVerticalStrut(6));
        header.add(titleLabel);
        header.add(Box.createVerticalStrut(4));
        header.add(subLabel);
        return header;
    }

    private JScrollPane buildBody() {
        JPanel body = new JPanel();
        body.setBackground(Color.WHITE);
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        body.add(buildPickCard());
        body.add(Box.createVerticalStrut(18));

        JLabel moreLabel = new JLabel("More ideas for you:");
        moreLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        moreLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        body.add(moreLabel);
        body.add(Box.createVerticalStrut(10));

        List<Activity> recommendations = engine.getRecommendations(mood);
        for (Activity a : recommendations) {
            body.add(buildActivityCard(a));
            body.add(Box.createVerticalStrut(10));
        }

        JScrollPane scrollPane = new JScrollPane(body);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(14);
        return scrollPane;
    }

    private RoundedPanel buildPickCard() {
        RoundedPanel card = new RoundedPanel(18, new Color(250, 250, 244));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setMaximumSize(new Dimension(10000, 230));

        JLabel tag = new JLabel("TODAY'S PICK");
        tag.setFont(new Font("Segoe UI", Font.BOLD, 11));
        tag.setForeground(mood.getFgColor());
        tag.setAlignmentX(Component.LEFT_ALIGNMENT);

        pickNameLabel = new JLabel(currentPick.getName());
        pickNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        pickNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        pickMetaLabel = new JLabel(currentPick.getCategory() + "  \u2022  " + currentPick.getDurationMinutes() + " min");
        pickMetaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        pickMetaLabel.setForeground(Color.GRAY);
        pickMetaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        pickMessageLabel = new JLabel(wrapHtml(currentPick.performActivity()));
        pickMessageLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        pickMessageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        RoundedButton rerollBtn = new RoundedButton("New Suggestion", 14);
        rerollBtn.setBackground(mood.getBgColor());
        rerollBtn.setForeground(mood.getFgColor());
        rerollBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        rerollBtn.setPreferredSize(new Dimension(160, 34));
        rerollBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        rerollBtn.addActionListener(e -> {
            currentPick = engine.getRandomActivity(mood);
            pickNameLabel.setText(currentPick.getName());
            pickMetaLabel.setText(currentPick.getCategory() + "  \u2022  " + currentPick.getDurationMinutes() + " min");
            pickMessageLabel.setText(wrapHtml(currentPick.performActivity()));
        });

        card.add(tag);
        card.add(Box.createVerticalStrut(6));
        card.add(pickNameLabel);
        card.add(pickMetaLabel);
        card.add(Box.createVerticalStrut(8));
        card.add(pickMessageLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(rerollBtn);
        return card;
    }

    private RoundedPanel buildActivityCard(Activity a) {
        RoundedPanel card = new RoundedPanel(14, new Color(246, 247, 250));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(12, 14, 12, 14));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setMaximumSize(new Dimension(10000, 140));

        JLabel nameLabel = new JLabel(a.getName());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel metaLabel = new JLabel(a.getCategory() + "  \u2022  " + a.getDurationMinutes() + " min");
        metaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        metaLabel.setForeground(Color.GRAY);
        metaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel descLabel = new JLabel(wrapHtml(a.getDescription()));
        descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(nameLabel);
        card.add(metaLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(descLabel);
        return card;
    }

    private JPanel buildFooter() {
        JPanel footer = new JPanel();
        footer.setBackground(Color.WHITE);
        footer.setBorder(BorderFactory.createEmptyBorder(8, 10, 16, 10));

        RoundedButton logBtn = new RoundedButton("Log & Close", 16);
        logBtn.setBackground(new Color(70, 190, 120));
        logBtn.setForeground(Color.WHITE);
        logBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        logBtn.setPreferredSize(new Dimension(150, 38));
        logBtn.addActionListener(e -> {
            user.addToHistory(mood, currentPick.getName());
            dispose();
        });

        RoundedButton closeBtn = new RoundedButton("Just Close", 16);
        closeBtn.setBackground(new Color(220, 220, 222));
        closeBtn.setForeground(Color.DARK_GRAY);
        closeBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        closeBtn.setPreferredSize(new Dimension(120, 38));
        closeBtn.addActionListener(e -> dispose());

        footer.add(logBtn);
        footer.add(closeBtn);
        return footer;
    }

    private String wrapHtml(String text) {
        return "<html><div style='width:360px;'>" + text + "</div></html>";
    }
}

// ---------------- DAILY MOOD JOURNAL DIALOG ----------------
class JournalPage extends JDialog {
    public JournalPage(JFrame parent, User user) {
        super(parent, "Daily Mood Journal", true);
        setSize(440, 350);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Write Today's Journal Entry", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        title.setBorder(BorderFactory.createEmptyBorder(15, 10, 5, 10));
        add(title, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        add(scrollPane, BorderLayout.CENTER);

        RoundedButton saveBtn = new RoundedButton("Save Entry", 14);
        saveBtn.setBackground(new Color(70, 190, 120));
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        saveBtn.addActionListener(e -> {
            String text = textArea.getText().trim();
            if (!text.isEmpty()) {
                user.addJournalEntry(text);
                JOptionPane.showMessageDialog(this, "Journal entry saved!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Journal entry cannot be empty.");
            }
        });

        JPanel bottom = new JPanel();
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 15, 10));
        bottom.add(saveBtn);
        add(bottom, BorderLayout.SOUTH);
    }
}

// ---------------- FEEDBACK DIALOG ----------------
class FeedbackPage extends JDialog {
    public FeedbackPage(JFrame parent, User user) {
        super(parent, "Submit Feedback", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("We Value Your Feedback", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 15));
        title.setBorder(BorderFactory.createEmptyBorder(15, 10, 5, 10));
        add(title, BorderLayout.NORTH);

        JTextArea feedbackArea = new JTextArea();
        feedbackArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        feedbackArea.setLineWrap(true);
        feedbackArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        add(scrollPane, BorderLayout.CENTER);

        RoundedButton submitBtn = new RoundedButton("Submit Feedback", 14);
        submitBtn.setBackground(new Color(80, 130, 255));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        submitBtn.addActionListener(e -> {
            String fb = feedbackArea.getText().trim();
            if (!fb.isEmpty()) {
                user.addFeedback(fb);
                JOptionPane.showMessageDialog(this, "Thank you for your feedback!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Feedback cannot be empty.");
            }
        });

        JPanel bottom = new JPanel();
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 15, 10));
        bottom.add(submitBtn);
        add(bottom, BorderLayout.SOUTH);
    }
}

// ---------------- COMBINED HISTORY PAGE ----------------
class HistoryPage extends JDialog {
    public HistoryPage(JFrame parent, User user) {
        super(parent, user.getUsername() + "'s History & Journal", true);
        setSize(500, 520);
        setLocationRelativeTo(parent);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 12));

        // Mood History Tab
        JPanel moodPanel = new JPanel(new BorderLayout());
        List<HistoryEntry> entries = user.getHistory();
        if (entries.isEmpty()) {
            JLabel empty = new JLabel("No activities logged yet.", SwingConstants.CENTER);
            empty.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            moodPanel.add(empty, BorderLayout.CENTER);
        } else {
            String[] columns = {"Mood", "Activity", "Time"};
            String[][] data = new String[entries.size()][3];
            for (int i = 0; i < entries.size(); i++) {
                HistoryEntry entry = entries.get(i);
                data[i][0] = entry.getMood().getEmoji() + " " + entry.getMood().getLabel();
                data[i][1] = entry.getActivityName();
                data[i][2] = entry.getTime();
            }
            JTable table = new JTable(data, columns);
            table.setRowHeight(28);
            table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            table.setEnabled(false);
            moodPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        }

        // Journal Entries Tab
        JPanel journalPanel = new JPanel(new BorderLayout());
        List<JournalEntry> journalEntries = user.getJournalEntries();
        if (journalEntries.isEmpty()) {
            JLabel empty = new JLabel("No journal entries logged yet.", SwingConstants.CENTER);
            empty.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            journalPanel.add(empty, BorderLayout.CENTER);
        } else {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (JournalEntry j : journalEntries) {
                listModel.addElement("[" + j.getTimestamp() + "] " + j.getText());
            }
            JList<String> jList = new JList<>(listModel);
            jList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            journalPanel.add(new JScrollPane(jList), BorderLayout.CENTER);
        }

        tabbedPane.addTab("Activity Logs", moodPanel);
        tabbedPane.addTab("Daily Journal", journalPanel);

        add(tabbedPane, BorderLayout.CENTER);

        RoundedButton closeBtn = new RoundedButton("Close", 15);
        closeBtn.setBackground(new Color(80, 130, 255));
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        closeBtn.setPreferredSize(new Dimension(100, 36));
        closeBtn.addActionListener(e -> dispose());

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        bottom.add(closeBtn);
        add(bottom, BorderLayout.SOUTH);
    }
}

// ---------------- MAIN APPLICATION WINDOW ----------------
public class MoodActivityRecommenderGUI extends JFrame {
    private final ActivityRecommenderEngine engine = new ActivityRecommenderEngine();
    private final Map<String, User> userDatabase = new HashMap<>();
    private User currentUser = null;
    private JLabel userWelcomeLabel;

    public MoodActivityRecommenderGUI() {
        setTitle("Mood Based Activity Recommender");
        setSize(580, 680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(245, 247, 250));
        setLayout(new BorderLayout(10, 10));

        add(buildHeader(), BorderLayout.NORTH);
        add(buildMoodGrid(), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
    }

    private JPanel buildHeader() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 247, 250));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel title = new JLabel("Mood Based Activity Recommender");
        title.setFont(new Font("Segoe UI", Font.BOLD, 21));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Answer a few questions and let the system predict your mood");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(Color.GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        userWelcomeLabel = new JLabel("Not Logged In");
        userWelcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        userWelcomeLabel.setForeground(new Color(60, 110, 210));
        userWelcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(4));
        panel.add(subtitle);
        panel.add(Box.createVerticalStrut(10));
        panel.add(userWelcomeLabel);
        return panel;
    }

    private JPanel buildMoodGrid() {
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(new Color(245, 247, 250));

        JPanel content = new JPanel();
        content.setBackground(new Color(245, 247, 250));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        RoundedPanel info = new RoundedPanel(20, Color.WHITE);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));
        info.setMaximumSize(new Dimension(470, 250));

        JLabel icon = new JLabel("🧠", SwingConstants.CENTER);
        icon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48));
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel heading = new JLabel("Discover Your Current Mood");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 20));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel description = new JLabel("<html><div style='text-align:center;width:390px;'>Answer 8 simple questions about your feelings, energy, stress, sleep and preferences. The system will calculate mood scores and select the best match.</div></html>");
        description.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        description.setForeground(Color.GRAY);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        RoundedButton assessBtn = new RoundedButton("Start Mood Assessment", 18);
        assessBtn.setBackground(new Color(80, 130, 255));
        assessBtn.setForeground(Color.WHITE);
        assessBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        assessBtn.setPreferredSize(new Dimension(230, 48));
        assessBtn.setMaximumSize(new Dimension(230, 48));
        assessBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        assessBtn.addActionListener(e -> openAssessment());

        info.add(icon);
        info.add(Box.createVerticalStrut(8));
        info.add(heading);
        info.add(Box.createVerticalStrut(8));
        info.add(description);
        info.add(Box.createVerticalStrut(18));
        info.add(assessBtn);

        content.add(info);
        wrapper.add(content);
        return wrapper;
    }

    private void openAssessment() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(this, "Please login first.");
            return;
        }
        new MoodAssessmentPage(this, engine, currentUser).setVisible(true);
    }

    private JPanel buildFooter() {
        JPanel footer = new JPanel();
        footer.setBackground(new Color(245, 247, 250));
        footer.setBorder(BorderFactory.createEmptyBorder(5, 10, 15, 10));

        RoundedButton journalBtn = new RoundedButton("Journal", 14);
        journalBtn.setBackground(new Color(140, 90, 210));
        journalBtn.setForeground(Color.WHITE);
        journalBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        journalBtn.setPreferredSize(new Dimension(100, 36));
        journalBtn.addActionListener(e -> { if (currentUser != null) new JournalPage(this, currentUser).setVisible(true); });

        RoundedButton historyBtn = new RoundedButton("History", 14);
        historyBtn.setBackground(new Color(80, 130, 255));
        historyBtn.setForeground(Color.WHITE);
        historyBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        historyBtn.setPreferredSize(new Dimension(100, 36));
        historyBtn.addActionListener(e -> { if (currentUser != null) new HistoryPage(this, currentUser).setVisible(true); });

        RoundedButton feedbackBtn = new RoundedButton("Feedback", 14);
        feedbackBtn.setBackground(new Color(70, 190, 120));
        feedbackBtn.setForeground(Color.WHITE);
        feedbackBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        feedbackBtn.setPreferredSize(new Dimension(100, 36));
        feedbackBtn.addActionListener(e -> { if (currentUser != null) new FeedbackPage(this, currentUser).setVisible(true); });

        RoundedButton logoutBtn = new RoundedButton("Logout", 14);
        logoutBtn.setBackground(new Color(230, 90, 90));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        logoutBtn.setPreferredSize(new Dimension(90, 36));
        logoutBtn.addActionListener(e -> performLogout());

        footer.add(journalBtn);
        footer.add(historyBtn);
        footer.add(feedbackBtn);
        footer.add(logoutBtn);
        return footer;
    }

    private void onMoodSelected(Mood mood) {
        RecommendationPage page = new RecommendationPage(this, engine, currentUser, mood);
        page.setVisible(true);
    }

    private void promptLogin() {
        AuthDialog auth = new AuthDialog(this, userDatabase);
        auth.setVisible(true);

        currentUser = auth.getAuthenticatedUser();
        if (currentUser == null) {
            System.exit(0);
        } else {
            userWelcomeLabel.setText("Welcome back, " + currentUser.getUsername() + "!");
        }
    }

    private void performLogout() {
        currentUser = null;
        JOptionPane.showMessageDialog(this, "Logged out successfully.");
        promptLogin();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(() -> {
            MoodActivityRecommenderGUI app = new MoodActivityRecommenderGUI();
            app.setVisible(true);
            app.promptLogin();
        });
    }
}
