package by.it.desykevich.jd03_02.beans;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {

        private int id;
        private String role;

        public Role(int id, String role) {
            this.id = id;
            this.role = role;
        }

        public Role() {
        }

        public int getId() {
            return id;
        }

        public void setId(int Id) {
            this.id = id;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "role{" +
                    "id=" + id +
                    ", role='" + role + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Role Role1 = (Role) o;
            return id == Role1.id &&
                    Objects.equals(role, Role1.role);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id, role);
        }
}
