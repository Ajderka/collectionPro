import java.util.List;

public class Analise {
    private Info analise;

    public Analise() {
        this.analise = new Analise.Info();
    }

    public int getDelete() {
        return analise.deleted;
    }

    public int getAdded() {
        return analise.added;
    }

    public int getChanged() {
        return analise.changed;
    }

    public void diff(List<User> previous, List<User> current) {
        for (User user : previous) {
            if (current.contains(user)) {
                for (User u : current) {
                    if (!u.name.equals(user.name) && u.id == user.id) {
                        analise.changed++;
                        break;
                    }
                }
            } else {
                analise.deleted++;
            }
        }
        for (User u : current) {
            if (!previous.contains(u)) {
                analise.added++;
            }
        }
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    private static class Info {
        private int added;
        private int changed;
        private int deleted;
    }
}
