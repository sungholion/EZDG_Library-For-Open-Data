import api from "@/lib/axios";
import type { GuideMenuItem, GuideData, ApiGuideData, FileGuideData } from "@/types/guide";

export const guideAPI = {
  // 가이드 메뉴 목록 조회
  getGuideMenu: async () => {
    try {
      const response = await api.get<GuideMenuItem[]>("/guide/menu")
      return response.data
    } catch (error) {
      console.log('Failed to fetch guide menu:', error);
      throw error;
    }
  },

  // API 타입 가이드 상세 정보 조회
  getGuideDetail: async (id: string, className: string) => {
    try {
      const response = await api.get<ApiGuideData>(`/guide/${id}/${className}`);
      return response.data
    } catch (error) {
      console.log('Failed to fetch api guide detail:', error)
      throw error;
    }
  },

  // File 타입 가이드 상세 정보 조회
  getFileDetail: async (id: string) => {
    try {
      const response = await api.get<FileGuideData>(`/guide/${id}`)
      return response.data;
    } catch (error) {
      console.log('Failed to fetch file guide detail:', error)
      throw error
    } 
  },

  // 타입 가드 함수들
  isApiGuide: (data: GuideData): data is ApiGuideData => {
    return data.type === 'api';
  },

  isFileGuide: (data: GuideData): data is FileGuideData => {
    return data.type === 'file';
  }
};