package com.atlas.mygoods.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images")
public class Image implements Serializable {

    public static final String IMAGE_ID = "image_id";

    @Id
//    @GenericGenerator(name = IMAGE_ID,strategy = "increment")
    @SequenceGenerator(
            name = "image_sequence",
            sequenceName = "image_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = IMAGE_ID)
    @Column(name = IMAGE_ID)
    private Long imageId;

    @Column(name = "imageUrl")
    private String imageURL;

    @Column(name = "imageName")
    private String imageName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "itemid")
//    private Item item;

    public Image(String imageURL) {
        this.imageURL = imageURL;
        this.imageName = "ImageName";
    }

    public Image(String imageURL, String imageName) {
        this.imageURL = imageURL;
        this.imageName = imageName;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId='" + imageId + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }

}
