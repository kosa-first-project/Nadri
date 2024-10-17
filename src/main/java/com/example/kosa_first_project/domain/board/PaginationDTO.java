package com.example.kosa_first_project.domain.board;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class PaginationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int totalSize; // 전체 항목
	private int totalPage; // 전체 페이지 수(전체 항목 수와 페이지 당 항목 수로 계산된다.)

	private int pageNo = 1; // 현재 페이지 번호(기본값 : 1)
	private int pageSize; // 페이지 당 보여줄 항목 개수
	private String pageName = "page"; // 페이지 파라미터 이름(주로 URL에 사용된다. 기본값 : page)

	// 페이지 순환 여부
	// (현재 페이지 번호가 전체 페이지 수 보다 클 경우 현재 페이지 설정 방법)
	private boolean pageLoop = false;

	private int pageOffset; // 현재 페이지의 첫 번째 항목의 인덱스(계산 방법 : (pageNo -1) * pageSize)
	private int pageFinal; // 현재 페이지 마지막 항목의 인덱스

	private int nationSize; // 페이지 네비게이션에서 한번에 보여줄 페이지 번호의 수 (Ex. 5개씩 보여준다.)
	private int nationBegin; // 페이지 네비게이션에서 보여줄 시작 번호
	private int nationClose; // 페이지 네비게이션에서 보여줄 끝 번호

	private String params; // 페이지 네비게이션 링크에 추가될 URL 파라미터(Ex. key1=value&key2=value2)


	//페이지 당 항목 개수, 페이지 네비게이션 묶음 당 수
	public PaginationDTO(int pageSize, int nationSize) {
		this.pageSize = pageSize;
		this.nationSize = nationSize;
	}

	//페이지 네비게이션 크기를 기본값(0)으로 설정하는 생성자
	public PaginationDTO(int pageSize) {
		this(pageSize,0);
	}

	//현재 페이지 번호를 설정한다.
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	//페이지 루프 여부를 설정한다.
	public void setPageLoop(boolean pageLoop) {
		this.pageLoop = pageLoop;
	}

	//전체 항목 수를 성정하고 _calc() 메서드를 호출하여 페이지를 계산한다.
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;

		this._calc();
	}

	//페이지 파라미터 이름을 설정한다.
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	//URL 파라미터를 설정한다.
	public void setParams(String params) {
		this.params = params;
	}

	//totalSize 또는 페이지 관련 값이 변경될 때 계산 수행
	private void _calc() {
		if (pageSize <= 0) return;

		// 전체 항목 수(totalSize)를 페이지 당 항목 수(pageSize)로 나누어 전체 페이지 수를 계산한다.
		totalPage = (int) Math.ceil(totalSize / (double) pageSize);
		if (totalPage < 1) {
			totalPage = 1;
		}

		// 현재 페이지 번호 확인
		// pageNo가 1보다 작으면 1로 설정한다.
		// pageNo가 totalPage보다 크면 페이지 루프 여부에 따라 첫 페이지로 가거나 마지막 페이지로 설정
		if (pageNo < 1) {
			pageNo = 1;
		}
		if (totalPage < pageNo) {
			pageNo = (pageLoop ? 1 : totalPage);
		}

		// 현재 페이지의 항목 범위 계산
		pageOffset = (pageNo - 1) * pageSize; // pageOffset : 현재 페이지의 첫 번째 항목의 인덱스를 계산
		pageFinal = pageOffset + pageSize; // 현재 페이지의 마지막 항목 인덱스를 계산하고, 마지막 항목이 전체 항목 수를 초과할 경우 조정
		if (pageFinal > totalSize) {
			pageFinal = totalSize;
		}

		// 페이지 네비게이션 계산
		if (nationSize > 0) {
			int share = (int) Math.floor(pageNo / (double) nationSize);

			nationBegin = (share * nationSize) + 1; // 네비게이션에서 보여줄 페이지 번호 범위를 계산한다.
			nationClose = (share + 1) * nationSize;

			if (nationClose > totalPage) {
				nationClose = totalPage;
			}
			if (pageNo % nationSize == 0) {
				nationBegin -= nationSize;
				nationClose = nationBegin + nationSize - 1;
			}
		}
	}

	@Override
	public String toString() {
		return "PaginateDto [totalSize=" + totalSize + ", totalPage=" + totalPage + ", pageNo=" + pageNo + ", pageSize="
				+ pageSize + ", pageOffset=" + pageOffset + ", pageFinal=" + pageFinal + ", nationSize=" + nationSize
				+ ", nationBegin=" + nationBegin + ", nationClose=" + nationClose + "]";
	}
}
