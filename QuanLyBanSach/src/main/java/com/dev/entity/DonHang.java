package com.dev.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;



@Entity
@Table(name = "DonHang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id", nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "ngay_dat_hang", nullable = false)
    private java.sql.Date ngayDatHang;

    @Column(name = "tong_tien", nullable = false)
    private Double tongTien;

    @OneToMany(mappedBy = "donHang")
    private Set<ChiTietDonHang> chiTietDonHangs;

    // Getters and Setters
    public DonHang() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public java.sql.Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(java.sql.Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

	public Set<ChiTietDonHang> getChiTietDonHangs() {
		return chiTietDonHangs;
	}

	public void setChiTietDonHangs(Set<ChiTietDonHang> chiTietDonHangs) {
		this.chiTietDonHangs = chiTietDonHangs;
	}
    
}
