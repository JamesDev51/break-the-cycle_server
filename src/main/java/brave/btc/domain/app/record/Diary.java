package brave.btc.domain.app.record;

import org.hibernate.annotations.Comment;

import brave.btc.constant.enums.RecordDivision;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue(RecordDivision.Values.DIARY)
@Table(name = "DIARY")
public class Diary extends Record {

	@Comment("일기 내용")
	@Column(name = "DIARY_CONTENT", columnDefinition = "VARCHAR(500) NOT NULL" , nullable = false)
	private String content;

}
