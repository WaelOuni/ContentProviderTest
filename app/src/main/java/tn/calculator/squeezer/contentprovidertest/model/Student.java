package tn.calculator.squeezer.contentprovidertest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Wael on 11/08/2015.
 */
public class Student implements Parcelable {
    public String nom;
    public String grade;

    public Student(String nom, String grade) {
        this.nom = nom;
        this.grade = grade;
    }

    public Student(Parcel source) {
        nom = source.readString();
        grade = source.readString();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nom='" + nom + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(nom);


        dest.writeString(grade);
    }

    public static  final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Student createFromParcel (Parcel in)
        {
            return new Student(in);
        }

        @Override
        public Object[] newArray(int size) {
            return new Student[size];
        }
    };
}
